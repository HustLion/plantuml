/* ========================================================================
 * PlantUML : a free UML diagram generator
 * ========================================================================
 *
 * (C) Copyright 2009-2017, Arnaud Roques
 *
 * Project Info:  http://plantuml.com
 * 
 * This file is part of PlantUML.
 *
 * PlantUML is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PlantUML distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public
 * License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc.
 * in the United States and other countries.]
 *
 * Original Author:  Arnaud Roques
 *
 * Revision $Revision: 4236 $
 * 
 */
package net.sourceforge.plantuml.svek;

import java.util.LinkedHashMap;
import java.util.Map;

public class Ports {

	private final Map<String, PortGeometry> all = new LinkedHashMap<String, PortGeometry>();

	public void addThis(Ports other) {
		all.putAll(other.all);
	}

	public Ports translateY(double deltaY) {
		final Ports result = new Ports();
		for (Map.Entry<String, PortGeometry> ent : all.entrySet()) {
			result.all.put(ent.getKey(), ent.getValue().translateY(deltaY));
		}
		return result;
	}

	public void add(String portName, double position, double height) {
		all.put(portName, new PortGeometry(position, height));
	}

	public Map<String, PortGeometry> getAll() {
		return all;
	}

}