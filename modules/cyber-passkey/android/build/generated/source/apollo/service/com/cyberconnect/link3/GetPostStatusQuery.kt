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
import com.cyberconnect.link3.adapter.GetPostStatusQuery_ResponseAdapter
import com.cyberconnect.link3.adapter.GetPostStatusQuery_VariablesAdapter
import com.cyberconnect.link3.selections.GetPostStatusQuerySelections
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit

public data class GetPostStatusQuery(
  public val postId: String,
) : Query<GetPostStatusQuery.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    GetPostStatusQuery_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> = GetPostStatusQuery_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = com.cyberconnect.link3.type.Query.type
  )
  .selections(selections = GetPostStatusQuerySelections.__root)
  .build()

  @ApolloAdaptableWith(GetPostStatusQuery_ResponseAdapter.Data::class)
  public data class Data(
    public val post: Post?,
  ) : Query.Data

  public data class Post(
    public val commentVisible: Boolean,
    public val commentCount: Int,
    public val likeCount: Int,
    public val dislikeCount: Int,
    public val essence: Essence?,
    public val likedStatus: LikedStatus,
  )

  public data class Essence(
    public val totalSupply: Int,
    public val totalCollected: Int,
    public val userBalance: Int,
  )

  public data class LikedStatus(
    public val liked: Boolean,
    public val disliked: Boolean,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "f40c2d3e33519d8b1f1ca173d5882a1ea26a44b43be12549d685e5118552c08e"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * query getPostStatus($postId: String!) {
     *   post(id: $postId) {
     *     commentVisible
     *     commentCount
     *     likeCount
     *     dislikeCount
     *     essence {
     *       totalSupply
     *       totalCollected
     *       userBalance
     *     }
     *     likedStatus {
     *       liked
     *       disliked
     *     }
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "query getPostStatus(${'$'}postId: String!) { post(id: ${'$'}postId) { commentVisible commentCount likeCount dislikeCount essence { totalSupply totalCollected userBalance } likedStatus { liked disliked } } }"

    public const val OPERATION_NAME: String = "getPostStatus"
  }
}