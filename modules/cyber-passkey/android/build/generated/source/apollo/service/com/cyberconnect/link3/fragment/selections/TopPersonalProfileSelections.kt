//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.fragment.selections

import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.notNull
import com.cyberconnect.link3.type.ConnectStatus
import com.cyberconnect.link3.type.GraphQLBoolean
import com.cyberconnect.link3.type.GraphQLID
import com.cyberconnect.link3.type.GraphQLInt
import com.cyberconnect.link3.type.GraphQLString
import com.cyberconnect.link3.type.PersonalDisplayName
import com.cyberconnect.link3.type.PersonalDisplayName_Type
import com.cyberconnect.link3.type.PersonalPicture
import com.cyberconnect.link3.type.ReputationScore
import com.cyberconnect.link3.type.Twitter
import com.cyberconnect.link3.type.User
import kotlin.collections.List

public object TopPersonalProfileSelections {
  private val __owner: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "id",
          type = GraphQLID.type.notNull()
        ).build()
      )

  private val __headline: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "displayName",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "title",
          type = GraphQLString.type.notNull()
        ).build()
      )

  private val __displayName1: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "displayName",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "type",
          type = PersonalDisplayName_Type.type.notNull()
        ).build()
      )

  private val __profilePicture: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "picture",
          type = GraphQLString.type
        ).build()
      )

  private val __reputation: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "total",
          type = GraphQLInt.type.notNull()
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
          name = "owner",
          type = User.type.notNull()
        ).selections(__owner)
        .build(),
        CompiledField.Builder(
          name = "headline",
          type = Twitter.type.notNull()
        ).selections(__headline)
        .build(),
        CompiledField.Builder(
          name = "displayName",
          type = PersonalDisplayName.type.notNull()
        ).selections(__displayName1)
        .build(),
        CompiledField.Builder(
          name = "profilePicture",
          type = PersonalPicture.type.notNull()
        ).selections(__profilePicture)
        .build(),
        CompiledField.Builder(
          name = "connectStatus",
          type = ConnectStatus.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "reputation",
          type = ReputationScore.type.notNull()
        ).selections(__reputation)
        .build(),
        CompiledField.Builder(
          name = "isVerified",
          type = GraphQLBoolean.type.notNull()
        ).build()
      )
}
