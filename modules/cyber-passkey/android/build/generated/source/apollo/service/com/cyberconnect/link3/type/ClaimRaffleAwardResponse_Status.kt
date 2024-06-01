//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.type

import com.apollographql.apollo3.api.EnumType
import kotlin.Array
import kotlin.String

public enum class ClaimRaffleAwardResponse_Status(
  public val rawValue: String,
) {
  SUCCESS("SUCCESS"),
  NOT_LOGIN("NOT_LOGIN"),
  INVALID_PARAMETER("INVALID_PARAMETER"),
  NOT_ELIGIBLE("NOT_ELIGIBLE"),
  CLAIMING_OTHER_TOKEN_AWARD("CLAIMING_OTHER_TOKEN_AWARD"),
  ALREADY_CLAIMED("ALREADY_CLAIMED"),
  /**
   * Auto generated constant for unknown enum values
   */
  UNKNOWN__("UNKNOWN__"),
  ;

  public companion object {
    public val type: EnumType = EnumType("ClaimRaffleAwardResponse_Status", listOf("SUCCESS",
        "NOT_LOGIN", "INVALID_PARAMETER", "NOT_ELIGIBLE", "CLAIMING_OTHER_TOKEN_AWARD",
        "ALREADY_CLAIMED"))

    public fun safeValueOf(rawValue: String): ClaimRaffleAwardResponse_Status =
        values().find { it.rawValue == rawValue } ?: UNKNOWN__

    /**
     * Returns all [ClaimRaffleAwardResponse_Status] known at compile time
     */
    public fun knownValues(): Array<ClaimRaffleAwardResponse_Status> = arrayOf(
      SUCCESS,
      NOT_LOGIN,
      INVALID_PARAMETER,
      NOT_ELIGIBLE,
      CLAIMING_OTHER_TOKEN_AWARD,
      ALREADY_CLAIMED)
  }
}