//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.type

import com.apollographql.apollo3.api.EnumType
import kotlin.Array
import kotlin.String

public enum class PersonalDisplayName_Type(
  public val rawValue: String,
) {
  GENERAL("GENERAL"),
  ENS("ENS"),
  SID("SID"),
  CYBER("CYBER"),
  /**
   * Auto generated constant for unknown enum values
   */
  UNKNOWN__("UNKNOWN__"),
  ;

  public companion object {
    public val type: EnumType = EnumType("PersonalDisplayName_Type", listOf("GENERAL", "ENS", "SID",
        "CYBER"))

    public fun safeValueOf(rawValue: String): PersonalDisplayName_Type =
        values().find { it.rawValue == rawValue } ?: UNKNOWN__

    /**
     * Returns all [PersonalDisplayName_Type] known at compile time
     */
    public fun knownValues(): Array<PersonalDisplayName_Type> = arrayOf(
      GENERAL,
      ENS,
      SID,
      CYBER)
  }
}