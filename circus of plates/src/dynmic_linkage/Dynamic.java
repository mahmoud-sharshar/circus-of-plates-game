package dynmic_linkage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Dynamic {

	private Class<? extends GameObject> plate;
	private String jarPath;

	public Class<? extends GameObject> getPlate() {
		return plate;
	}

	public Dynamic(String path) {
		this.jarPath = path;
	}

	public HashMap<String, BufferedImage> loadPictures() {

		HashMap<String, BufferedImage> pictures = new HashMap<>();
		try {
			JarFile jar = new JarFile("dyn.jar");
			Enumeration<JarEntry> e = jar.entries();
			URL[] urls = { new URL("jar:file:dyn.jar!/") };

			URLClassLoader cl = URLClassLoader.newInstance(urls);

			while (e.hasMoreElements()) {
				JarEntry je = e.nextElement();
				if (je.getName().contains(".class")) {
					String name = je.getName().substring(0, je.getName().length() - 6);
					name = name.replace('/', '.');
					
					
					if (name.contains("Plate")) {
						try {
							plate = (Class<? extends GameObject>) cl.loadClass(name);
						} catch (ClassNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						
					}
				} 
			}
			Enumeration<JarEntry> e1 = jar.entries();
			while (e1.hasMoreElements()) {
				JarEntry je = e1.nextElement();
				if (je.getName().contains(".png") || je.getName().contains(".jpg")) {
					pictures.put(je.getName(), ImageIO.read(plate.getResource(("/"+je.getName()))));
					System.out.println(je.getName());
				}
			}
			jar.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pictures;

	}
	
	public void load(String path) {
		File file = new File(path);
		try {
			URL url = file.toURI().toURL();

			URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
			Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
			method.setAccessible(true);
			method.invoke(classLoader, url);
		} catch (Exception e) {
			throw new RuntimeException("Unexpected exception", e);
		}
	}
	
}
