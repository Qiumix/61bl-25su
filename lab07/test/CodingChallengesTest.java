import org.junit.Test;

import static com.google.common.truth.Truth.assertWithMessage;

public class CodingChallengesTest {

    @Test
    public void testMissingNumber() {
	// TODO
        int[] testArray1 = {2, 1, 0, 3, 5, 6};
        assertWithMessage("The missing number should be 4")
                .that(CodingChallenges.missingNumber(testArray1))
                .isEqualTo(4);
        int[] testArray2 = {};
        assertWithMessage("The missing number should be 0")
                .that(CodingChallenges.missingNumber(testArray2))
                .isEqualTo(0);
    }

    @Test
    public void testIsPermutation() {
        String s1 = "hello";
        String s2 = "holle";
        assertWithMessage("s1 is equal to s2")
                .that(CodingChallenges.isPermutation(s1, s2))
                .isEqualTo(true);
        s1 = "welcome";
        s2 = "holle";
        assertWithMessage("s1 is not equal to s2")
                .that(CodingChallenges.isPermutation(s1, s2))
                .isEqualTo(false);
        s1 = "";
        s2 = "";
        assertWithMessage("s1 is equal to s2")
                .that(CodingChallenges.isPermutation(s1, s2))
                .isEqualTo(true);
	// TODO
    }
}