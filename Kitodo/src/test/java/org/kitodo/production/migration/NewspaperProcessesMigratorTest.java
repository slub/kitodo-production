/*
 * (c) Kitodo. Key to digital objects e. V. <contact@kitodo.org>
 *
 * This file is part of the Kitodo project.
 *
 * It is licensed under GNU General Public License version 3 or later.
 *
 * For the full copyright and license information, please read the
 * GPL3-License.txt file that was distributed with this source code.
 */

package org.kitodo.production.migration;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.kitodo.data.database.beans.Batch;


public class NewspaperProcessesMigratorTest {

    @Test
    public void checkNewspaperShortedTitleGeneration() {
        Batch testBatch = new Batch();
        testBatch.setTitle("Test Batch for Newspaper Shorted Title Generation");
        testBatch.setId(1234);

        List<String> listOfNewspaperTitles = Arrays.asList(
                "Aben_399196951",
                "DresNa_516710338",
                "LeipMofT_1679165712",
                "StaaHofM_1031939121",
                "Zeit_425552225",
                "AdorWo_1838560793",
                "ErzgGe_1843119854",
                "HoheTa_1841109282",
                "HoheTa_184110793X",
                "RabeAn_178001192X",
                "WilsTa_1782027106",
                "WochfWiT_1782021922",
                "WochfWiu_1782024719",
                "WochunAnf_1841066850",
                "ZschTa_1780081065",
                "ZschTaunA_1780077211"
        );

        NewspaperProcessesMigrator migrator = new NewspaperProcessesMigrator(testBatch);
        for (String newspaperTitle : listOfNewspaperTitles) {
            String dailyTitle = newspaperTitle + "-20210804";
            String multipleDailyTitle = dailyTitle + "01p_01-p";
            Assert.assertEquals(newspaperTitle, migrator.generateNewspaperShortTitle(dailyTitle));
            Assert.assertEquals(newspaperTitle, migrator.generateNewspaperShortTitle(multipleDailyTitle));
        }
    }
}
