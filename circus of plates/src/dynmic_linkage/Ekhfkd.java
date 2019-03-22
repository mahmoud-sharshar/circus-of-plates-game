package dynmic_linkage;

import java.awt.image.BufferedImage;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Ekhfkd {
	private static Class<? extends GameObject> plate;

	public static void main(String[] args) throws ClassNotFoundException {
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
					
					System.out.println(name);
					if (name.contains("Plate")) {
						plate = (Class<? extends GameObject>) cl.loadClass(name);
						System.out.println("kljsfl");
						System.out.println(plate);
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
	}
}
