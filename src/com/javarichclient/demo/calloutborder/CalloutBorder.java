/**************************************************************************
 * Copyright 2010 by SDNJ Technologies Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or
 * without modification, are strictly probited without permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * ``AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * REGENTS OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 ****************************************************************************/

package com.javarichclient.demo.calloutborder;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.AbstractBorder;

/**
 *
 * @author Jim
 */
public class CalloutBorder extends AbstractBorder {

    Insets insets = new Insets(20, 10, 10, 10);

    public CalloutBorder() {
    }

    @Override
    public Insets getBorderInsets(Component cmpnt) {
        return insets;
    }

    @Override
    public Insets getBorderInsets(Component cmpnt, Insets insets) {
        insets.left = this.insets.left;
        insets.right = this.insets.right;
        insets.top = this.insets.top;
        insets.bottom = this.insets.bottom;
        return insets;
    }



    @Override
    public void paintBorder(Component cmpnt, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;

        // turn Anti-aliasing on to make the corners smooth
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(2));
        g.setColor(Color.BLACK);

        // create the callout "tip"
        int tipCenter = x+width/3;
        GeneralPath p = new GeneralPath();
        p.moveTo(tipCenter-insets.left, y+insets.top/2);
        p.lineTo(tipCenter, 0);
        p.lineTo(tipCenter+insets.top/2, y+insets.top/2);
        p.closePath();

        // create the shape
        RoundRectangle2D rect = new RoundRectangle2D.Double(x, y+insets.top/2, width-1, height-1-insets.top/2, 20, 20);
        Area area = new Area(rect);
        area.add( new Area(p) );

        g2d.draw(area); // draw the shape
    }
}
