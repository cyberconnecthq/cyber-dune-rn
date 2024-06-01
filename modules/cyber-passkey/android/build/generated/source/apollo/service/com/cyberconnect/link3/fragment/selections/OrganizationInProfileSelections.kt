//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.fragment.selections

import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.notNull
import com.cyberconnect.link3.type.Attestation
import com.cyberconnect.link3.type.Attestation_Status
import com.cyberconnect.link3.type.Attestation_Type
import com.cyberconnect.link3.type.GraphQLID
import com.cyberconnect.link3.type.GraphQLInt
import com.cyberconnect.link3.type.GraphQLString
import com.cyberconnect.link3.type.OrganizationLightInfo
import com.cyberconnect.link3.type.ReviewingOrganization
import com.cyberconnect.link3.type.Role
import com.cyberconnect.link3.type.VerificationStatus
import kotlin.collections.List

public object OrganizationInProfileSelections {
  private val __reviewing: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "handle",
          type = GraphQLString.type.notNull()
        ).build()
      )

  private val __attestation: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "status",
          type = Attestation_Status.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "uid",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "type",
          type = Attestation_Type.type.notNull()
        ).build()
      )

  private val __lightInfo: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "attestation",
          type = Attestation.type
        ).selections(__attestation)
        .build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "id",
          type = GraphQLID.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "twitterId",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "verification",
          type = VerificationStatus.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "currentAccess",
          type = Role.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "followersCount",
          type = GraphQLInt.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "reviewing",
          type = ReviewingOrganization.type
        ).selections(__reviewing)
        .build(),
        CompiledField.Builder(
          name = "lightInfo",
          type = OrganizationLightInfo.type.notNull()
        ).selections(__lightInfo)
        .build()
      )
}