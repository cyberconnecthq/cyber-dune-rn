//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.fragment.selections

import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.notNull
import com.cyberconnect.link3.type.GraphQLID
import com.cyberconnect.link3.type.GraphQLString
import com.cyberconnect.link3.type.Organization
import com.cyberconnect.link3.type.VerificationStatus
import kotlin.collections.List

public object FollowingOrgsSelections {
  private val __organization: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "verification",
          type = VerificationStatus.type.notNull()
        ).build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "id",
          type = GraphQLID.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "handle",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "displayName",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "profilePicture",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "organization",
          type = Organization.type.notNull()
        ).selections(__organization)
        .build()
      )
}