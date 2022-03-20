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
 * The Legalities data model describes a list of legalities in play formats for a specific card.
 */
class Legalities @ConstructorProperties(
    "brawl",
    "commander",
    "duel",
    "future",
    "frontier",
    "historic",
    "legacy",
    "modern",
    "pauper",
    "penny",
    "pioneer",
    "standard",
    "vintage"
) constructor(

    /**
     * Gets legality in the Brawl play format.
     *
     * @return The legality in the Brawl play format.
     */
    val brawl: String?,

    /**
     * Gets legality in the Commander play format.
     *
     * @return The legality in the Commander play format.
     */
    val commander: String?,

    /**
     * Gets legality in the Duel Commander play format.
     *
     * @return The legality in the Duel Commander play format.
     */
    val duel: String?,

    /**
     * Gets legality in the Future play format.
     *
     * @return The legality in the Future  play format.
     */
    val future: String?,

    /**
     * Gets legality in the Frontier play format.
     *
     * @return The legality in the Frontier play format.
     */
    val frontier: String?,

    /**
     * Gets legality in the Historic play format.
     *
     * @return The legality in the Historic play format.
     */
    val historic: String?,

    /**
     * Gets legality in the Legacy play format.
     *
     * @return The legality in the Legacy play format.
     */
    val legacy: String?,

    /**
     * Gets legality in the Modern play format.
     *
     * @return The legality in the Modern play format.
     */
    val modern: String?,

    /**
     * Gets legality in the Pauper play format.
     *
     * @return The legality in the Pauper play format.
     */
    val pauper: String?,

    /**
     * Gets legality in the Penny play format.
     *
     * @return The legality in the Penny play format.
     */
    val penny: String?,

    /**
     * Gets legality in the Pioneer play format.
     *
     * @return The legality in the Pioneer play format.
     */
    val pioneer: String?,

    /**
     * Gets legality in the Standard play format.
     *
     * @return The legality in the Standard play format.
     */
    val standard: String?,

    /**
     * Gets legality in the Vintage play format.
     *
     * @return The legality in the Vintage play format.
     */
    val vintage: String?
) {

    override fun toString(): String {
        val sb = StringBuilder()
        if (brawl != null) {
            sb.append("Brawl: ").append(brawl).append('\n')
        }
        if (commander != null) {
            sb.append("Commander: ").append(commander).append('\n')
        }
        if (duel != null) {
            sb.append("Duel: ").append(duel).append('\n')
        }
        if (future != null) {
            sb.append("Future: ").append(future).append('\n')
        }
        if (frontier != null) {
            sb.append("Frontier: ").append(frontier).append('\n')
        }
        if (historic != null) {
            sb.append("Historic: ").append(historic).append('\n')
        }
        if (legacy != null) {
            sb.append("Legacy: ").append(legacy).append('\n')
        }
        if (modern != null) {
            sb.append("Modern: ").append(modern).append('\n')
        }
        if (pauper != null) {
            sb.append("Pauper: ").append(pauper).append('\n')
        }
        if (penny != null) {
            sb.append("Penny: ").append(penny).append('\n')
        }
        if (pioneer != null) {
            sb.append("Pioneer: ").append(pioneer).append('\n')
        }
        if (standard != null) {
            sb.append("Standard: ").append(standard).append('\n')
        }
        if (vintage != null) {
            sb.append("Vintage: ").append(vintage).append('\n')
        }
        return sb.toString()
    }
}