//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.type

import com.apollographql.apollo3.api.EnumType
import kotlin.Array
import kotlin.Deprecated
import kotlin.String
import kotlin.Suppress

public enum class PaidStatus(
  public val rawValue: String,
) {
  @Deprecated(message = "No longer supported")
  UNPAID("UNPAID"),
  @Deprecated(message = "No longer supported")
  PENDING("PENDING"),
  PAID("PAID"),
  EARNED("EARNED"),
  REFUNDED("REFUNDED"),
  /**
   * Auto generated constant for unknown enum values
   */
  UNKNOWN__("UNKNOWN__"),
  ;

  public companion object {
    public val type: EnumType = EnumType("PaidStatus", listOf("UNPAID", "PENDING", "PAID", "EARNED",
        "REFUNDED"))

    public fun safeValueOf(rawValue: String): PaidStatus = values().find { it.rawValue == rawValue }
        ?: UNKNOWN__

    /**
     * Returns all [PaidStatus] known at compile time
     */
    @Suppress("DEPRECATION")
    public fun knownValues(): Array<PaidStatus> = arrayOf(
      UNPAID,
      PENDING,
      PAID,
      EARNED,
      REFUNDED)
  }
}
