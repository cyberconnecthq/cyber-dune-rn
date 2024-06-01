//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.selections

import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledFragment
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.notNull
import com.cyberconnect.link3.type.ChatPriceFeedback
import com.cyberconnect.link3.type.GraphQLBoolean
import com.cyberconnect.link3.type.GraphQLID
import com.cyberconnect.link3.type.GraphQLString
import com.cyberconnect.link3.type.LinkedinInfo
import com.cyberconnect.link3.type.MeResponse
import com.cyberconnect.link3.type.MeResponse_Status
import com.cyberconnect.link3.type.PriceFeedback
import com.cyberconnect.link3.type.PrivateInfo
import com.cyberconnect.link3.type.Profile
import com.cyberconnect.link3.type.Telegram
import com.cyberconnect.link3.type.User
import kotlin.collections.List

public object SettingsQuerySelections {
  private val __linkedinInfo: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "needRefresh",
          type = GraphQLBoolean.type.notNull()
        ).build()
      )

  private val __telegram: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "telegramId",
          type = GraphQLID.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "username",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "subscribed",
          type = GraphQLBoolean.type.notNull()
        ).build()
      )

  private val __privateInfo: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "accessToken",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "twitterId",
          type = GraphQLID.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "discordId",
          type = GraphQLID.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "email",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "linkedinId",
          type = GraphQLID.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "linkedinInfo",
          type = LinkedinInfo.type.notNull()
        ).selections(__linkedinInfo)
        .build(),
        CompiledField.Builder(
          name = "githubId",
          type = GraphQLID.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "telegram",
          type = Telegram.type
        ).selections(__telegram)
        .build()
      )

  private val __priceFeedback: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "feedback",
          type = ChatPriceFeedback.type
        ).build()
      )

  private val __onPerProfile: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "isVerified",
          type = GraphQLBoolean.type.notNull()
        ).build()
      )

  private val __profile: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "__typename",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledFragment.Builder(
          typeCondition = "PerProfile",
          possibleTypes = listOf("PerProfile")
        ).selections(__onPerProfile)
        .build()
      )

  private val __data: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "id",
          type = GraphQLID.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "privateInfo",
          type = PrivateInfo.type
        ).selections(__privateInfo)
        .build(),
        CompiledField.Builder(
          name = "priceFeedback",
          type = PriceFeedback.type.notNull()
        ).selections(__priceFeedback)
        .build(),
        CompiledField.Builder(
          name = "profile",
          type = Profile.type
        ).selections(__profile)
        .build()
      )

  private val __me: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "status",
          type = MeResponse_Status.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "message",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "data",
          type = User.type
        ).selections(__data)
        .build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "me",
          type = MeResponse.type.notNull()
        ).selections(__me)
        .build()
      )
}
