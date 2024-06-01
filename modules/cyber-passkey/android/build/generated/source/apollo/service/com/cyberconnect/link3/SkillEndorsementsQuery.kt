//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3

import com.apollographql.apollo3.annotations.ApolloAdaptableWith
import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.Query
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.adapter.SkillEndorsementsQuery_ResponseAdapter
import com.cyberconnect.link3.adapter.SkillEndorsementsQuery_VariablesAdapter
import com.cyberconnect.link3.selections.SkillEndorsementsQuerySelections
import kotlin.Any
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public data class SkillEndorsementsQuery(
  public val skillId: String,
) : Query<SkillEndorsementsQuery.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    SkillEndorsementsQuery_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> = SkillEndorsementsQuery_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = com.cyberconnect.link3.type.Query.type
  )
  .selections(selections = SkillEndorsementsQuerySelections.__root)
  .build()

  @ApolloAdaptableWith(SkillEndorsementsQuery_ResponseAdapter.Data::class)
  public data class Data(
    public val endorsements: Endorsements,
  ) : Query.Data

  public data class Endorsements(
    public val endorsed: Boolean,
    public val users: List<User>,
  )

  public data class User(
    public val id: String,
    public val lightInfo: LightInfo,
    public val profile: Profile?,
  )

  public data class LightInfo(
    public val handle: String,
    public val avatar: String,
    public val displayName: String,
    public val formattedAddress: String,
    public val attestation: Attestation?,
  )

  public data class Attestation(
    public val uid: String,
  )

  public data class Profile(
    public val __typename: String,
    public val id: String,
    /**
     * Synthetic field for inline fragment on PerProfile
     */
    public val onPerProfile: OnPerProfile?,
  )

  public data class OnPerProfile(
    /**
     * Personal headline, including Title and Organization.
     */
    public val headline: Headline,
    public val isVerified: Boolean,
  )

  public data class Headline(
    public val twitterId: String,
    public val twitterHandle: String,
    public val displayName: String,
    public val avatar: Any,
    public val title: String,
    public val description: String,
    public val profileId: String?,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "47ebfe6dfcdcb45ce1d9b537286971b88eb58761f5c7fe25dfdbb88f1736d053"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * query skillEndorsements($skillId: ID!) {
     *   endorsements(skillId: $skillId) {
     *     endorsed
     *     users {
     *       id
     *       lightInfo {
     *         handle
     *         avatar
     *         displayName
     *         formattedAddress
     *         attestation {
     *           uid
     *         }
     *       }
     *       profile {
     *         __typename
     *         id
     *         ... on PerProfile {
     *           headline {
     *             twitterId
     *             twitterHandle
     *             displayName
     *             avatar
     *             title
     *             description
     *             profileId
     *           }
     *           isVerified
     *         }
     *       }
     *     }
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "query skillEndorsements(${'$'}skillId: ID!) { endorsements(skillId: ${'$'}skillId) { endorsed users { id lightInfo { handle avatar displayName formattedAddress attestation { uid } } profile { __typename id ... on PerProfile { headline { twitterId twitterHandle displayName avatar title description profileId } isVerified } } } } }"

    public const val OPERATION_NAME: String = "skillEndorsements"
  }
}