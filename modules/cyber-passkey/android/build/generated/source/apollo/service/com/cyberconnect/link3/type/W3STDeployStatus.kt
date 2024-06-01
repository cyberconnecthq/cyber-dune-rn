//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.type

import com.apollographql.apollo3.api.EnumType
import kotlin.Array
import kotlin.String

public enum class W3STDeployStatus(
  public val rawValue: String,
) {
  PROFILE_NOT_DEPLOYED("PROFILE_NOT_DEPLOYED"),
  DEPLOYING_PROFILE("DEPLOYING_PROFILE"),
  PROFILE_DEPLOYED("PROFILE_DEPLOYED"),
  PROFILE_DEPLOY_FAILED("PROFILE_DEPLOY_FAILED"),
  DEPLOYING_W3ST("DEPLOYING_W3ST"),
  W3ST_DEPLOY_FAILED("W3ST_DEPLOY_FAILED"),
  ALL_DEPLOYED("ALL_DEPLOYED"),
  /**
   * Auto generated constant for unknown enum values
   */
  UNKNOWN__("UNKNOWN__"),
  ;

  public companion object {
    public val type: EnumType = EnumType("W3STDeployStatus", listOf("PROFILE_NOT_DEPLOYED",
        "DEPLOYING_PROFILE", "PROFILE_DEPLOYED", "PROFILE_DEPLOY_FAILED", "DEPLOYING_W3ST",
        "W3ST_DEPLOY_FAILED", "ALL_DEPLOYED"))

    public fun safeValueOf(rawValue: String): W3STDeployStatus =
        values().find { it.rawValue == rawValue } ?: UNKNOWN__

    /**
     * Returns all [W3STDeployStatus] known at compile time
     */
    public fun knownValues(): Array<W3STDeployStatus> = arrayOf(
      PROFILE_NOT_DEPLOYED,
      DEPLOYING_PROFILE,
      PROFILE_DEPLOYED,
      PROFILE_DEPLOY_FAILED,
      DEPLOYING_W3ST,
      W3ST_DEPLOY_FAILED,
      ALL_DEPLOYED)
  }
}
