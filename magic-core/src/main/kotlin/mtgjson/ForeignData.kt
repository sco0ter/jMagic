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
 * The Foreign Data data model describes a list of properties for various card data models in alternate languages.
 *
 *
 * This class is immutable.
 */
class ForeignData @ConstructorProperties(
    "faceName",
    "flavorText",
    "language",
    "multiverseId",
    "name",
    "text",
    "type"
) constructor(

    /**
     * Gets the name on the face of the card.
     *
     * @return The name on the face of the card.
     */
    val faceName: String?,

    /**
     * Gets the flavor text of the card.
     *
     * @return The flavor text of the card.
     */
    val flavorText: String?,

    /**
     * Gets the foreign language of card.
     *
     * @return The foreign language of card.
     */
    val language: String,

    /**
     * Gets the multiverse identifier of the card.
     *
     * @return The multiverse identifier of the card.
     */
    val multiverseId: Int?,

    /**
     * Gets the name of the card.
     *
     * @return The name of the card.
     */
    val name: String,

    /**
     * Gets the text ruling of the card.
     *
     * @return The text ruling of the card.
     */
    val text: String?,

    /**
     * Gets the type of the card. Includes any supertypes and subtypes.
     *
     * @return The type of the card. Includes any supertypes and subtypes.
     */
    val type: String?
) {
    override fun toString(): String {
        return "$name ($language)"
    }
}