//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.type

import com.apollographql.apollo3.api.EnumType
import kotlin.Array
import kotlin.String

public enum class EssenceMwType(
  public val rawValue: String,
) {
  ESSENCE_MW_NONE("ESSENCE_MW_NONE"),
  ESSENCE_MW_LIMITED_TIME_PAID("ESSENCE_MW_LIMITED_TIME_PAID"),
  ESSENCE_MW_PERMISSION("ESSENCE_MW_PERMISSION"),
  ESSENCE_MW_ONLY_SUBSCRIBED("ESSENCE_MW_ONLY_SUBSCRIBED"),
  ESSENCE_MW_PAID("ESSENCE_MW_PAID"),
  ESSENCE_MW_PERMISSION_PAID("ESSENCE_MW_PERMISSION_PAID"),
  ESSENCE_MW_FLEX_PAID("ESSENCE_MW_FLEX_PAID"),
  V3_ESSENCE_MW_PERMISSION("V3_ESSENCE_MW_PERMISSION"),
  V3_ESSENCE_MW_LIMITED("V3_ESSENCE_MW_LIMITED"),
  /**
   * Auto generated constant for unknown enum values
   */
  UNKNOWN__("UNKNOWN__"),
  ;

  public companion object {
    public val type: EnumType = EnumType("EssenceMwType", listOf("ESSENCE_MW_NONE",
        "ESSENCE_MW_LIMITED_TIME_PAID", "ESSENCE_MW_PERMISSION", "ESSENCE_MW_ONLY_SUBSCRIBED",
        "ESSENCE_MW_PAID", "ESSENCE_MW_PERMISSION_PAID", "ESSENCE_MW_FLEX_PAID",
        "V3_ESSENCE_MW_PERMISSION", "V3_ESSENCE_MW_LIMITED"))

    public fun safeValueOf(rawValue: String): EssenceMwType =
        values().find { it.rawValue == rawValue } ?: UNKNOWN__

    /**
     * Returns all [EssenceMwType] known at compile time
     */
    public fun knownValues(): Array<EssenceMwType> = arrayOf(
      ESSENCE_MW_NONE,
      ESSENCE_MW_LIMITED_TIME_PAID,
      ESSENCE_MW_PERMISSION,
      ESSENCE_MW_ONLY_SUBSCRIBED,
      ESSENCE_MW_PAID,
      ESSENCE_MW_PERMISSION_PAID,
      ESSENCE_MW_FLEX_PAID,
      V3_ESSENCE_MW_PERMISSION,
      V3_ESSENCE_MW_LIMITED)
  }
}
