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
import com.apollographql.apollo3.api.Optional
import com.apollographql.apollo3.api.Query
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.adapter.FollowingsQuery_ResponseAdapter
import com.cyberconnect.link3.adapter.FollowingsQuery_VariablesAdapter
import com.cyberconnect.link3.fragment.MyConnectionItem
import com.cyberconnect.link3.selections.FollowingsQuerySelections
import com.cyberconnect.link3.type.MeResponse_Status
import kotlin.String
import kotlin.Unit

public data class FollowingsQuery(
  public val after: Optional<String?> = Optional.Absent,
) : Query<FollowingsQuery.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    FollowingsQuery_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> = FollowingsQuery_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = com.cyberconnect.link3.type.Query.type
  )
  .selections(selections = FollowingsQuerySelections.__root)
  .build()

  @ApolloAdaptableWith(FollowingsQuery_ResponseAdapter.Data::class)
  public data class Data(
    public val me: Me,
  ) : Query.Data

  public data class Me(
    public val status: MeResponse_Status,
    public val message: String,
    public val `data`: Data1?,
  )

  public data class Data1(
    public val profile: Profile?,
  )

  public data class Profile(
    public val __typename: String,
    /**
     * Synthetic field for inline fragment on PerProfile
     */
    public val onPerProfile: OnPerProfile?,
  )

  public data class OnPerProfile(
    public val connecting: Connecting,
  )

  public data class Connecting(
    public val pageInfo: PageInfo,
    public val list: kotlin.collections.List<List>,
  )

  public data class PageInfo(
    public val __typename: String,
    /**
     * Synthetic field for 'PageInfo'
     */
    public val pageInfo: com.cyberconnect.link3.fragment.PageInfo,
  )

  public data class List(
    public val __typename: String,
    /**
     * Synthetic field for 'MyConnectionItem'
     */
    public val myConnectionItem: MyConnectionItem,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "36b2c5188cedb19354e1c910e33a467202884a916e0cb3a8833eda4c7ef32e6c"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * query followings($after: String) {
     *   me {
     *     status
     *     message
     *     data {
     *       profile {
     *         __typename
     *         ... on PerProfile {
     *           connecting(first: 20, after: $after) {
     *             pageInfo {
     *               __typename
     *               ...PageInfo
     *             }
     *             list {
     *               __typename
     *               ...MyConnectionItem
     *             }
     *           }
     *         }
     *       }
     *     }
     *   }
     * }
     *
     * fragment PageInfo on PageInfo {
     *   startCursor
     *   endCursor
     *   hasNextPage
     *   hasPreviousPage
     * }
     *
     * fragment MyConnectionItem on Profile {
     *   __typename
     *   id
     *   handle
     *   ... on PerProfile {
     *     owner {
     *       id
     *       lightInfo {
     *         attestation {
     *           uid
     *         }
     *         remark
     *       }
     *     }
     *     isVerified
     *     connectStatus
     *     headline {
     *       title
     *       twitterHandle
     *       displayName
     *     }
     *     personalDisplayName: displayName {
     *       displayName
     *     }
     *     personalProfilePicture: profilePicture {
     *       picture
     *     }
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "query followings(${'$'}after: String) { me { status message data { profile { __typename ... on PerProfile { connecting(first: 20, after: ${'$'}after) { pageInfo { __typename ...PageInfo } list { __typename ...MyConnectionItem } } } } } } }  fragment PageInfo on PageInfo { startCursor endCursor hasNextPage hasPreviousPage }  fragment MyConnectionItem on Profile { __typename id handle ... on PerProfile { owner { id lightInfo { attestation { uid } remark } } isVerified connectStatus headline { title twitterHandle displayName } personalDisplayName: displayName { displayName } personalProfilePicture: profilePicture { picture } } }"

    public const val OPERATION_NAME: String = "followings"
  }
}
