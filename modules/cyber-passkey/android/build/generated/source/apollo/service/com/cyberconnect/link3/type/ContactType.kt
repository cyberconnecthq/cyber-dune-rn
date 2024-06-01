//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.type

import com.apollographql.apollo3.api.EnumType
import kotlin.Array
import kotlin.String

public enum class ContactType(
  public val rawValue: String,
) {
  EMAIL("EMAIL"),
  TWITTER("TWITTER"),
  LINKEDIN("LINKEDIN"),
  GITHUB("GITHUB"),
  /**
   * Auto generated constant for unknown enum values
   */
  UNKNOWN__("UNKNOWN__"),
  ;

  public companion object {
    public val type: EnumType = EnumType("ContactType", listOf("EMAIL", "TWITTER", "LINKEDIN",
        "GITHUB"))

    public fun safeValueOf(rawValue: String): ContactType =
        values().find { it.rawValue == rawValue } ?: UNKNOWN__

    /**
     * Returns all [ContactType] known at compile time
     */
    public fun knownValues(): Array<ContactType> = arrayOf(
      EMAIL,
      TWITTER,
      LINKEDIN,
      GITHUB)
  }
}