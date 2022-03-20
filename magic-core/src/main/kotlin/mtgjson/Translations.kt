/*
 * MIT License
 *
 * Copyright (c) 2022 Christian Schudt
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

package mtgjson

import java.beans.ConstructorProperties

/**
 * The Translations data model describes the translated data per language as a key.
 *
 * This class is immutable.
 */
class Translations @ConstructorProperties(
    "Ancient Greek",
    "Arabic",
    "Chinese Simplified",
    "Chinese Traditional",
    "French",
    "German",
    "Hebrew",
    "Italian",
    "Japanese",
    "Korean",
    "Latin",
    "Phyrexian",
    "Portuguese (Brazil)",
    "Russian",
    "Sanskrit",
    "Spanish"
) constructor(

    /**
     * Gets the set name translation in Ancient Greek.
     *
     * @return The set name translation in Ancient Greek.
     */
    val ancientGreek: String?,

    /**
     * Gets the set name translation in Arabic.
     *
     * @return The set name translation in Arabic.
     */
    val arabic: String?,

    /**
     * Gets the set name translation in Chinese Simplified.
     *
     * @return The set name translation in Chinese Simplified.
     */
    val chineseSimplified: String?,

    /**
     * Gets the set name translation in Chinese Traditional.
     *
     * @return The set name translation in Chinese Traditional.
     */
    val chineseTraditional: String?,

    /**
     * Gets the set name translation in French.
     *
     * @return The set name translation in French.
     */
    val french: String?,

    /**
     * Gets the set name translation in German.
     *
     * @return The set name translation in German.
     */
    val german: String?,

    /**
     * Gets the set name translation in Hebrew.
     *
     * @return The set name translation in Hebrew.
     */
    val hebrew: String?,

    /**
     * Gets the set name translation in Italian.
     *
     * @return The set name translation in Italian.
     */
    val italian: String?,

    /**
     * Gets the set name translation in Japanese.
     *
     * @return The set name translation in Japanese.
     */
    val japanese: String?,

    /**
     * Gets the set name translation in Korean.
     *
     * @return The set name translation in Korean.
     */
    val korean: String?,

    /**
     * Gets the set name translation in Latin.
     *
     * @return The set name translation in Latin.
     */
    val latin: String?,

    /**
     * Gets the set name translation in Phyrexian.
     *
     * @return The set name translation in Phyrexian.
     */
    val phyrexian: String?,

    /**
     * Gets the set name translation in Portuguese (Brazil).
     *
     * @return The set name translation in Portuguese (Brazil).
     */
    val portuguese: String?,

    /**
     * Gets the set name translation in Russian.
     *
     * @return The set name translation in Russian.
     */
    val russian: String?,

    /**
     * Gets the set name translation in Sanskrit.
     *
     * @return The set name translation in Sanskrit.
     */
    val sanskrit: String?,

    /**
     * Gets the set name translation in Spanish.
     *
     * @return The set name translation in Spanish.
     */
    val spanish: String?
) {

    override fun toString(): String {
        val sb = StringBuilder("Translations{")
        if (ancientGreek != null) {
            sb.append("ancientGreek='").append(ancientGreek).append("', ")
        }
        if (arabic != null) {
            sb.append("arabic='").append(arabic).append("', ")
        }
        if (chineseSimplified != null) {
            sb.append("chineseSimplified='").append(chineseSimplified).append("', ")
        }
        if (chineseTraditional != null) {
            sb.append("chineseTraditional='").append(chineseTraditional).append("', ")
        }
        if (french != null) {
            sb.append("french='").append(french).append("', ")
        }
        if (german != null) {
            sb.append("german='").append(german).append("', ")
        }
        if (hebrew != null) {
            sb.append("hebrew='").append(hebrew).append("', ")
        }
        if (italian != null) {
            sb.append("italian='").append(italian).append("', ")
        }
        if (japanese != null) {
            sb.append("japanese='").append(japanese).append("', ")
        }
        if (korean != null) {
            sb.append("korean='").append(korean).append("', ")
        }
        if (latin != null) {
            sb.append("latin='").append(latin).append("', ")
        }
        if (phyrexian != null) {
            sb.append("phyrexian='").append(phyrexian).append("', ")
        }
        if (portuguese != null) {
            sb.append("portuguese='").append(portuguese).append("', ")
        }
        if (russian != null) {
            sb.append("russian='").append(russian).append("', ")
        }
        if (sanskrit != null) {
            sb.append("sanskrit='").append(sanskrit).append("', ")
        }
        if (spanish != null) {
            sb.append("spanish='").append(spanish).append("', ")
        }
        sb.setLength(sb.length - 2)
        sb.append('}')
        return sb.toString()
    }
}