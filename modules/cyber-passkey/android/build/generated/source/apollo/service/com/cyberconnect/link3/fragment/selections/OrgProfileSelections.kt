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
import com.cyberconnect.link3.type.Organization
import com.cyberconnect.link3.type.ProfileType
import kotlin.collections.List

public object OrgProfileSelections {
  private val __organization: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "__typename",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledFragment.Builder(
          typeCondition = "Organization",
          possibleTypes = listOf("Organization")
        ).selections(OrganizationInProfileSelections.__root)
        .build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "handle",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "bio",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "cmcTokenId",
          type = GraphQLID.type.notNull()
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
          name = "sector",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "networks",
          type = GraphQLString.type.notNull().list().notNull()
        ).build(),
        CompiledField.Builder(
          name = "displayName",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "isFollowing",
          type = GraphQLBoolean.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "type",
          type = ProfileType.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "organization",
          type = Organization.type.notNull()
        ).selections(__organization)
        .build()
      )
}
