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

package org.kitodo.exceptions;

/**
 * This exception is thrown when some specific parameter could not be found in a configuration file.
 */
public class ParameterNotFoundException extends Exception {

    /**
     * Standard constructor with a message String.
     *
     * @param message exception message
     */
    public ParameterNotFoundException(String message) {
        super(message);
    }
}
