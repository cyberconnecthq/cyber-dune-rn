//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.type

import com.apollographql.apollo3.api.EnumType
import kotlin.Array
import kotlin.String

public enum class VerificationStatus(
  public val rawValue: String,
) {
  /**
   * Default status. User can submit a organization profile handle.
   */
  NONE("NONE"),
  /**
   * Waiting for verification from the LinkΞ team.
   */
  PENDING("PENDING"),
  /**
   * Verified by the LinkΞ team.
   */
  VERIFIED("VERIFIED"),
  /**
   * Twitter not verified by the LinkΞ team.
   */
  TWITTER_REJECTED("TWITTER_REJECTED"),
  /**
   * Handle not verified by the LinkΞ team.
   */
  HANDLE_REJECTED("HANDLE_REJECTED"),
  /**
   * Handle has been registered by the LinkΞ team.
   */
  HANDLE_REGISTERED("HANDLE_REGISTERED"),
  /**
   * Auto generated constant for unknown enum values
   */
  UNKNOWN__("UNKNOWN__"),
  ;

  public companion object {
    public val type: EnumType = EnumType("VerificationStatus", listOf("NONE", "PENDING", "VERIFIED",
        "TWITTER_REJECTED", "HANDLE_REJECTED", "HANDLE_REGISTERED"))

    public fun safeValueOf(rawValue: String): VerificationStatus =
        values().find { it.rawValue == rawValue } ?: UNKNOWN__

    /**
     * Returns all [VerificationStatus] known at compile time
     */
    public fun knownValues(): Array<VerificationStatus> = arrayOf(
      NONE,
      PENDING,
      VERIFIED,
      TWITTER_REJECTED,
      HANDLE_REJECTED,
      HANDLE_REGISTERED)
  }
}
