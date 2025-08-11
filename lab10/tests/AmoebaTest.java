import edu.princeton.cs.algs4.In;
import org.antlr.v4.runtime.tree.Tree;
import org.antlr.v4.runtime.tree.Trees;
import org.junit.Test;
import src.AmoebaFamily;

import java.util.Iterator;

import static com.google.common.truth.Truth.assertThat;

public class AmoebaTest {

    @Test
    public void testLongestName() {
        AmoebaFamily family = new AmoebaFamily("Amos McCoy");
        family.addChild("Amos McCoy", "mom/dad");
        family.addChild("Amos McCoy", "auntie");
        family.addChild("mom/dad", "me");
        family.addChild("mom/dad", "Fred");
        family.addChild("mom/dad", "Wilma");
        family.addChild("me", "Mike");
        family.addChild("me", "Homer");
        family.addChild("me", "Marge");
        family.addChild("Mike", "Bart");
        family.addChild("Mike", "Lisa");
        family.addChild("Marge", "Bill");
        family.addChild("Marge", "Hilary");
        assertThat(family.longestName()).isEqualTo("Amos McCoy");
        AmoebaFamily t = new AmoebaFamily("tea");
        t.addChild("tea", "black");
        t.addChild("tea", "green");
        t.addChild("tea", "white");
        t.addChild("black", "earl grey");
        t.addChild("black", "prince of wales");
        t.addChild("green", "genmaicha");
        t.addChild("green", "sencha");
        t.addChild("green", "matcha");
        t.addChild("matcha", "ceremonial grade matcha");
        t.addChild("white", "silver needle");
        assertThat(t.longestName()).isEqualTo("ceremonial grade matcha");
    }

    @Test
    public void testSingleBFS() {
        AmoebaFamily family = new AmoebaFamily("amoeb");
        String[] expected = { "amoeb" };
        int i = 0;
        for (AmoebaFamily.Amoeba a : family) {
            assertThat(a.toString()).isEqualTo(expected[i]);
            i++;
        }
        assertThat(i).isEqualTo(1);
    }

    @Test
    public void testSimpleBFS() {
        AmoebaFamily family = new AmoebaFamily("courtney");
        family.addChild("courtney", "samantha");
        family.addChild("courtney", "joey");
        String[] expected = { "courtney", "samantha", "joey" };
        int i = 0;
        for (AmoebaFamily.Amoeba a : family) {
            assertThat(a.toString()).isEqualTo(expected[i]);
            i++;
        }
        assertThat(i).isEqualTo(3);
    }

    @Test
    public void testBFS() {
        AmoebaFamily family = new AmoebaFamily("(._.)");
        family.addChild("(._.)", "(._. )");
        family.addChild("(._.)", "( ._.)");
        family.addChild("(._. )", ":/");
        family.addChild("(._. )", "<_<");
        family.addChild("<_<", ">_<");
        family.addChild("( ._.)", ">_>");
        family.addChild(">_>", ":o");
        String[] expected = { "(._.)", "(._. )", "( ._.)", ":/", "<_<", ">_>",
                ">_<", ":o" };
        int i = 0;
        Iterator<AmoebaFamily.Amoeba> iterator = family.iterator();
        for (AmoebaFamily.Amoeba a : family) {
            assertThat(a.toString()).isEqualTo(expected[i]);
            i++;
        }
        assertThat(i).isEqualTo(8);
    }

    @Test
    public void testSkinnyBFS() {
        AmoebaFamily family = new AmoebaFamily("(._.)");
        family.addChild("(._.)", "(._. )");
        family.addChild("(._. )", "( ._.)");
        family.addChild("(._. )", ":/");
        family.addChild(":/", ">_>");
        String[] expected = { "(._.)", "(._. )", "( ._.)", ":/", ">_>" };
        int i = 0;
        for (AmoebaFamily.Amoeba a : family) {
            assertThat(a.toString()).isEqualTo(expected[i]);
            i++;
        }
        assertThat(i).isEqualTo(5);
    }
}