//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.type

import com.apollographql.apollo3.api.EnumType
import kotlin.Array
import kotlin.String

public enum class MessageType(
  public val rawValue: String,
) {
  TEXT("TEXT"),
  IMAGE("IMAGE"),
  /**
   * Auto generated constant for unknown enum values
   */
  UNKNOWN__("UNKNOWN__"),
  ;

  public companion object {
    public val type: EnumType = EnumType("MessageType", listOf("TEXT", "IMAGE"))

    public fun safeValueOf(rawValue: String): MessageType =
        values().find { it.rawValue == rawValue } ?: UNKNOWN__

    /**
     * Returns all [MessageType] known at compile time
     */
    public fun knownValues(): Array<MessageType> = arrayOf(
      TEXT,
      IMAGE)
  }
}