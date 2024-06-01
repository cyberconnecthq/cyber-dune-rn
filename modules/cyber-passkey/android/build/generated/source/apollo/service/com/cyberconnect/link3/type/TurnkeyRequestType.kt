//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.type

import com.apollographql.apollo3.api.EnumType
import kotlin.Array
import kotlin.String

public enum class TurnkeyRequestType(
  public val rawValue: String,
) {
  WHO_AM_I("WHO_AM_I"),
  UPDATE_USER("UPDATE_USER"),
  EXPORT_WALLET("EXPORT_WALLET"),
  /**
   * Auto generated constant for unknown enum values
   */
  UNKNOWN__("UNKNOWN__"),
  ;

  public companion object {
    public val type: EnumType = EnumType("TurnkeyRequestType", listOf("WHO_AM_I", "UPDATE_USER",
        "EXPORT_WALLET"))

    public fun safeValueOf(rawValue: String): TurnkeyRequestType =
        values().find { it.rawValue == rawValue } ?: UNKNOWN__

    /**
     * Returns all [TurnkeyRequestType] known at compile time
     */
    public fun knownValues(): Array<TurnkeyRequestType> = arrayOf(
      WHO_AM_I,
      UPDATE_USER,
      EXPORT_WALLET)
  }
}
