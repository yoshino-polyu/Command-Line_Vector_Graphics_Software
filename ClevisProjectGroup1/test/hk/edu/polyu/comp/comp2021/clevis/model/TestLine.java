package hk.edu.polyu.comp.comp2021.clevis.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class TestLine {
    @Test
    public void testLineLineInter0() {
        Line a = new Line("testLine_a",1f, 0f, 4f, 3f);
        Line b = new Line("testLine_b",3f, 2f, 5f, 0f);
        assertTrue(a.isIntersected(b));
    }

    @Test
    public void testLineLineInter1() {
        Line c = new Line("testLine_c",2f, 1f, 4.54455f, 2.90361f);
        Line d = new Line("testLine_d",5f, 1f, 3.76700f, 2.25936f);
        assertFalse(c.isIntersected(d));
    }

    @Test
    public void testLineLineInter2() {
        Line e = new Line("testLine_e",2f, 1f, 5.58439f, 1.84772f);
        Line f = new Line("testLine_f",7.76492f, 3.50908f, 5.58570f, 1.84792f);
        assertFalse(e.isIntersected(f));
    }

    @Test
    public void testLineLineInter3() {
        Line g = new Line("testLine_g",2f, 1f, 5.58439f, 1.84772f);
        Line h = new Line("testLine_h",4.75361f, 2.53426f, 7.25039f, 3.12476f);
        assertFalse(g.isIntersected(h));
    }

    @Test
    public void testLineLineInter4() {
        // Two lines are collinear and overlap.
        Line i = new Line("testLine_i",0.4f, 0.2f, 1f, 0.4f);
        Line j = new Line("testLine_j",0.98853f, 0.39617f, 1.02908f, 0.40942f); // 6.5494454E-10 == 0
        assertTrue(i.isIntersected(j));
    }
//---------------------------------------------------------------------------------------------------------

    @Test
    public void testLineCircle0() {
        // Test the case 1 in isIntersected (C is inside the circle, while E is on the circle.
        Line m = new Line("testLine_m",1.58108f, 0.52904f, 1.81107f, 0.58522f);// // C=(1.5810852441577,0.529044492787), E=(1.8110792856131,0.5852268110847)
        Circle n = new Circle("testLine_n",1.4f, 0.6f, 0.41134f); // r = 0.4113446561837, r^2 = 0.1692044261709
        assertFalse(m.isIntersected(n)); // should return true. EPS = E-5 -> return true, EPS = E-6 return false.
    }

    @Test
    public void testLineCircle1() {
        // Test the case 2 in isIntersected (C is inside the circle, while E is also inside the circle and very close to the edge of the circle.
        Line o = new Line("testLine_o",1.58108f, 0.52904f, 1.80967f, 0.56514f); //  C=(1.5810852441577,0.529044492787), E=(1.8096701976124, 0.5651425422479)
        Circle p = new Circle("testCircle_p",1.4f, 0.6f, 0.41134f);
        assertFalse(o.isIntersected(p));
    }

    @Test
    public void testLineCircle2() {
        // Test the case 3 in isIntersected (C is inside and very close to the edge of the circle, while E is outside the circle.
        Line q = new Line("testLine_q",5.63272f, 2.11447f, 5.8f, 2.2f); // C=(5.6327232539627,2.1144774811828) E=(5.8,2.2)
        Circle r = new Circle("testCircle_r",5f, 1.5f, 0.88282f); // r^2 = 0.7793879360436; 圆心(5,1.5), r = 0.8828295056485
        assertTrue(q.isIntersected(r));
    }

    @Test
    public void testLineCircle3() {
        // Test the case 4 in isIntersected -> (C is outside and very close to the edge, while E is outside, and Angle OCE is an obtuse angle.
        Line s = new Line("testLine_s",5.70881f, 2.02690f, 5.8f, 2.2f); //C=(5.7088162554534,2.0269028675004) E(5.8,2.2)
        Circle t = new Circle("testCircle_t",5f, 1.5f, 0.88282f);
        assertFalse(s.isIntersected(t));
    }

    @Test
    public void testLineCircle4() {
        // Test the case 4 in isIntersected -> (E is outside and very close to the edge, while C is outsdie, and Angle OEC is an obtuse angle.
        Line u = new Line("testLine_u",6.14052f, 1.67203f, 5.81448f, 1.84154f); // C=(6.1405259654056,1.6720304489816) E=(5.8144842166463,1.8415481023994)
        Circle v = new Circle("testCircle_v",5f, 1.5f, 0.88282f);
        assertFalse(u.isIntersected(v));
    }

    @Test
    public void testLineCircle5() {
        // Test the case 4 in isIntersected (OCE three points collinear, C outside and very close to edge, E outside)
        Line w = new Line("testLine_w",5.75173f, 1.96447f, 6.50728f, 2.43129f); // C=(5.751737320268,1.9644721307078), E=(6.5072850254938,2.4312985646709)
        Circle x = new Circle("testCircle_x",5f, 1.5f, 0.88282f);
        assertFalse(w.isIntersected(x));
    }

    @Test
    public void testLineCircle6() {
        // Test the case 5 in isIntersected (return true case)
        Line y = new Line("testLine_y",5.86287f, 1.99221f, 5.00002f, 2.38373f); // C=(5.8628787616036,1.9922184547504), E=(5.0000271200151,2.3837344989143)
        Circle z = new Circle("testCircle_z",5f, 1.5f, 0.88282f);
        assertTrue(y.isIntersected(z));
    }

    @Test
    public void testLineCircle7() {
        // Test the case 5 in isIntersected (return false case)
        Line z1 = new Line("testLine_z1",5.62228f,2.17108f, 4.67439f,2.68657f);// C=(5.6222897599635,2.1710883379339) E=(4.6743966199911,2.6865796067336)
        Circle z2 = new Circle("testCircle_z2",5f, 1.5f, 0.88282f);
        assertFalse(z1.isIntersected(z2));
    }
}
