package DawkinsWeasel;

import org.junit.jupiter.api.Test;

import static DawkinsWeasel.DawkinsWeasel.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DawkinsWeaselTest {

    @Test
    public void selectsRandomCharFromGivenString() {
        String allCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        String character = String.valueOf(getRandomCharFromString());
        assertThat(allCharacters).contains(character);
    }

    @Test
    public void generatesRandomStringWithTwentyEightCharacters() {
        int stringLength = generateRandomString(28).length();
        assertEquals(28, stringLength);
    }

    @Test
    public void validateScoring() {
        String target = "METHINKS IT IS LIKE A WEASEL";
        String randomString = "METHINKS IT IN LIKE I WEASEL";
        int score = score(randomString, target);
        assertEquals(26, score);
    }
}
