//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.fragment.selections

import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledFragment
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.list
import com.apollographql.apollo3.api.notNull
import com.cyberconnect.link3.type.GraphQLBoolean
import com.cyberconnect.link3.type.GraphQLID
import com.cyberconnect.link3.type.GraphQLString
import com.cyberconnect.link3.type.InvitationCode
import com.cyberconnect.link3.type.Profile
import com.cyberconnect.link3.type.ProfileType
import com.cyberconnect.link3.type.ReviewingOrganization
import com.cyberconnect.link3.type.Role
import com.cyberconnect.link3.type.VerificationStatus
import kotlin.collections.List

public object OrganizationInDashboardSelections {
  private val __invitationCodes: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "code",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "isUsed",
          type = GraphQLBoolean.type.notNull()
        ).build()
      )

  private val __reviewing: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "handle",
          type = GraphQLString.type.notNull()
        ).build()
      )

  private val __onOrgProfile: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "displayName",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "profilePicture",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "backgroundPicture",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "bio",
          type = GraphQLString.type.notNull()
        ).build()
      )

  private val __profile: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "__typename",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "id",
          type = GraphQLID.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "type",
          type = ProfileType.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "handle",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledFragment.Builder(
          typeCondition = "OrgProfile",
          possibleTypes = listOf("OrgProfile")
        ).selections(__onOrgProfile)
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
          name = "invitationCodes",
          type = InvitationCode.type.notNull().list()
        ).selections(__invitationCodes)
        .build(),
        CompiledField.Builder(
          name = "reviewing",
          type = ReviewingOrganization.type
        ).selections(__reviewing)
        .build(),
        CompiledField.Builder(
          name = "profile",
          type = Profile.type.notNull()
        ).selections(__profile)
        .build()
      )
}
