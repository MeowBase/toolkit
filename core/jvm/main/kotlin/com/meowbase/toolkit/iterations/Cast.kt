/*
 * Copyright (c) 2021. Rin Orz (凛)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 *
 * Github home page: https://github.com/RinOrz
 */

package com.meowbase.toolkit.iterations

import kotlin.collections.toList
import kotlin.collections.toMutableList
import kotlin.collections.toMutableMap
import kotlin.collections.toMutableSet
import kotlin.collections.toSet

/** [Iterable] safety convert to [MutableList] */
fun <T> Iterable<T>.toMutableList(): MutableList<T> =
  if (this is MutableList) this else toMutableList()

/** [Collection] safety convert to [MutableList] */
fun <T> Collection<T>.toMutableList(): MutableList<T> =
  if (this is MutableList) this else toMutableList()

/** [List] safety convert to [MutableList] */
fun <T> List<T>.toMutableList(): MutableList<T> =
  if (this is MutableList) this else toMutableList()


/** [Iterable] safety convert to [MutableSet] */
fun <T> Iterable<T>.toMutableSet(): MutableSet<T> =
  if (this is MutableSet) this else toMutableSet()

/** [Collection] safety convert to [MutableSet] */
fun <T> Collection<T>.toMutableSet(): MutableSet<T> =
  if (this is MutableSet) this else toMutableSet()

/** [Iterable] safety convert to [Set] */
fun <T> Iterable<T>.toSet(): Set<T> =
  if (this is Set) this else toSet()

/** [Collection] safety convert to [MutableSet] */
fun <T> Collection<T>.toSet(): Set<T> =
  if (this is Set) this else toMutableSet()


/** [Iterable] safety convert to [List] */
fun <T> Iterable<T>.toList(): List<T> =
  if (this is List) this else toList()

/** [Collection] safety convert to [MutableList] */
fun <T> Collection<T>.toList(): List<T> =
  if (this is List) this else toMutableList()


/** [Map] safety convert to [MutableMap] */
fun <K, V> Map<K, V>.toMutableMap(): MutableMap<K, V> =
  if (this is MutableMap<K, V>) this else toMutableMap()