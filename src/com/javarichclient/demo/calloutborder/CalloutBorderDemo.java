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

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jim
 */
public class CalloutBorderDemo {
    public static void main(String args[]) {
        JFrame f = new JFrame("CalloutBorderDemo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel cp = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;

                GradientPaint gp = new GradientPaint(0f, 0f, Color.WHITE, 0f, getHeight(), Color.DARK_GRAY);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        f.setContentPane(cp);

        JLabel calloutLabel = new JLabel("<html>This is a JLabel<br>with a CalloutBorder.</html>");
        calloutLabel.setIcon(new ImageIcon(CalloutBorderDemo.class.getResource("simley.png")));
//        calloutLabel.setOpaque(true);
//        calloutLabel.setBackground(Color.ORANGE);
        calloutLabel.setBorder(new CalloutBorder());

        f.getContentPane().setLayout(new FlowLayout());
        f.getContentPane().add(calloutLabel);
        f.setSize(400, 200);
        f.setVisible(true);

    }
}
