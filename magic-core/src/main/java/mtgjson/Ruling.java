/*
 * MIT License
 *
 * Copyright (c) 2021 Christian Schudt
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package mtgjson;

import java.beans.ConstructorProperties;
import java.time.LocalDate;

/**
 * The Rulings data model describes a list of rulings for a specific card.
 */
public final class Ruling {

    private final LocalDate date;

    private final String text;

    @ConstructorProperties({"date", "text"})
    public Ruling(LocalDate date, String text) {
        this.date = date;
        this.text = text;
    }

    /**
     * Gets the release date for the rule.
     *
     * @return The release date for the rule.
     */
    public final LocalDate getDate() {
        return date;
    }

    /**
     * Gets the text ruling of the card.
     *
     * @return The text ruling of the card.
     */
    public final String getText() {
        return text;
    }

    @Override
    public final String toString() {
        return text + " (" + date + ')';
    }
}
