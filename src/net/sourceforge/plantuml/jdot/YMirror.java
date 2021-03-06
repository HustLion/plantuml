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
package net.sourceforge.plantuml.jdot;

import java.awt.geom.CubicCurve2D;
import java.awt.geom.Point2D;

import net.sourceforge.plantuml.posimo.DotPath;
import net.sourceforge.plantuml.ugraphic.UTranslate;

public class YMirror {

	private final double max;

	public YMirror(double max) {
		this.max = max;
	}

	public double getMirrored(double v) {
		if (v < 0 || v > max) {
			throw new IllegalArgumentException();
		}
		//return v;
		return max - v;
	}

	public Point2D getMirrored(Point2D pt) {
		//return pt;
		return new Point2D.Double(pt.getX(), max - pt.getY());
	}

	public DotPath getMirrored(DotPath path) {
		DotPath result = new DotPath();
		for (CubicCurve2D.Double bez : path.getBeziers()) {
			result = result.addCurve(getMirrored(bez.getP1()), getMirrored(bez.getCtrlP1()),
					getMirrored(bez.getCtrlP2()), getMirrored(bez.getP2()));
		}
		return result;
	}

	public UTranslate getMirrored(UTranslate tr) {
		return new UTranslate(tr.getDx(), max - tr.getDy());
		//return tr;
	}

}
