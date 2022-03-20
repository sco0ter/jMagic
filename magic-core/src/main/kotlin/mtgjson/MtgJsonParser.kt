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

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.ObjectReader
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import java.io.IOException
import java.io.InputStream
import java.io.UncheckedIOException
import java.util.*
import java.util.Spliterators.AbstractSpliterator
import java.util.function.Consumer
import java.util.stream.Stream
import java.util.stream.StreamSupport

object MtgJsonParser {

    private val OBJECT_READER: ObjectReader

    @JvmStatic
    @Throws(IOException::class)
    fun parseAllPrintings(inputStream: InputStream): Stream<Set> {
        return parse(inputStream, true)
    }

    @JvmStatic
    @Throws(IOException::class)
    fun parseSet(inputStream: InputStream): Optional<Set> {
        return parse(inputStream, false).findFirst()
    }

    @JvmStatic
    @Throws(IOException::class)
    fun parse(inputStream: InputStream, skip: Boolean): Stream<Set> {
        val parser = OBJECT_READER.createParser(inputStream)

        // move to start of document
        parser.nextValue()
        // move to "meta" element
        parser.nextValue()
        // skip "meta" element
        parser.skipChildren()
        if (skip) {
            parser.nextValue()
        }
        return StreamSupport.stream(MtgJsonSpliterator(parser), false)
    }

    private class MtgJsonSpliterator(private val parser: JsonParser) :
        AbstractSpliterator<Set>(Long.MAX_VALUE, DISTINCT or NONNULL or IMMUTABLE) {
        override fun tryAdvance(action: Consumer<in Set>): Boolean {
            return try {
                if (parser.nextValue() != null) {
                    val set = parser.readValueAs(Set::class.java)
                    if (set != null) {
                        action.accept(set)
                    }
                    return true
                }
                false
            } catch (e: IOException) {
                throw UncheckedIOException(e)
            }
        }
    }

    init {
        val mapper = ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        mapper.registerModule(JavaTimeModule())
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        OBJECT_READER = mapper.reader()
    }

}