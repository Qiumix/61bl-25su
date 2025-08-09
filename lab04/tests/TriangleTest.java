import org.junit.Test;

import static com.google.common.truth.Truth.assertWithMessage;
public abstract class TriangleTest {

    /** For autograding purposes; do not change this line. */
    abstract Triangle getNewTriangle();

    /* ***** TESTS ***** */

    // FIXME: Add additional tests for Triangle.java here that pass on a
    //  correct Triangle implementation and fail on buggy Triangle implementations.

    @Test
    public void test1() {
        // TODO: stub for first test
        Triangle t = getNewTriangle();
        // remember that you'll have to call on Triangle methods like
        // t.functionName(arguments), where t is a Triangle object

    }

    @Test
    public void test2() {
        Triangle triangle = getNewTriangle();
        assertWithMessage("actual is not expected")
                .that(triangle.sidesFormTriangle(1, 2, 3))
                .isEqualTo(false);
        assertWithMessage("actual is not expected")
                .that(triangle.sidesFormTriangle(3, 3, 3))
                .isEqualTo(true);
        assertWithMessage("actual is not expected")
                .that(triangle.sidesFormTriangle(3, 4, 5))
                .isEqualTo(true);
        assertWithMessage("actual is not expected")
                .that(triangle.sidesFormTriangle(0, 0, 0))
                .isEqualTo(false);
    }

    @Test
    public void test3() {
        Triangle triangle = getNewTriangle();
        assertWithMessage("actual is not expected")
                .that(triangle.pointsFormTriangle(1, 1, 1, 1, 1, 1))
                .isEqualTo(true);
        assertWithMessage("actual is not expected")
                .that(triangle.pointsFormTriangle(1, 1, 0, 0, -1, -1))
                .isEqualTo(false);
        assertWithMessage("actual is not expected")
                .that(triangle.pointsFormTriangle(1, 1, 0, 0, -1, -1))
                .isEqualTo(false);
    }

    @Test
    public void test4() {
        Triangle triangle = getNewTriangle();
        assertWithMessage("actual is not expected")
                .that(triangle.triangleType(1, 1, 1))
                .isEqualTo("Equilateral");
        assertWithMessage("actual is not expected")
                .that(triangle.triangleType(2, 1, 1))
                .isEqualTo("Isosceles");
        assertWithMessage("actual is not expected")
                .that(triangle.triangleType(3, 4, 5))
                .isEqualTo("Scalene");
    }

    @Test
    public void test5() {
        Triangle triangle = getNewTriangle();
        assertWithMessage("actual is not expected")
                .that(triangle.squaredHypotenuse(3, 4))
                .isEqualTo(25);
        assertWithMessage("actual is not expected")
                .that(triangle.squaredHypotenuse(4, 4))
                .isEqualTo(32);
        assertWithMessage("actual is not expected")
                .that(triangle.squaredHypotenuse(1, 4))
                .isEqualTo(17);
    }


}