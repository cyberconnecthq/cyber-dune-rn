//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.type

import com.apollographql.apollo3.api.EnumType
import kotlin.Array
import kotlin.String

public enum class EventRegisterStatus(
  public val rawValue: String,
) {
  NOT_REGISTERED("NOT_REGISTERED"),
  REGISTERED("REGISTERED"),
  ADDED_TO_CALENDAR("ADDED_TO_CALENDAR"),
  /**
   * Auto generated constant for unknown enum values
   */
  UNKNOWN__("UNKNOWN__"),
  ;

  public companion object {
    public val type: EnumType = EnumType("EventRegisterStatus", listOf("NOT_REGISTERED",
        "REGISTERED", "ADDED_TO_CALENDAR"))

    public fun safeValueOf(rawValue: String): EventRegisterStatus =
        values().find { it.rawValue == rawValue } ?: UNKNOWN__

    /**
     * Returns all [EventRegisterStatus] known at compile time
     */
    public fun knownValues(): Array<EventRegisterStatus> = arrayOf(
      NOT_REGISTERED,
      REGISTERED,
      ADDED_TO_CALENDAR)
  }
}
