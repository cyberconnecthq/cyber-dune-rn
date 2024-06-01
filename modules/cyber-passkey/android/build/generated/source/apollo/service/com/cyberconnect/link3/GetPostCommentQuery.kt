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
import com.cyberconnect.link3.adapter.GetPostCommentQuery_ResponseAdapter
import com.cyberconnect.link3.adapter.GetPostCommentQuery_VariablesAdapter
import com.cyberconnect.link3.selections.GetPostCommentQuerySelections
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit

public data class GetPostCommentQuery(
  public val postId: String,
  public val first: Optional<Int?> = Optional.Absent,
  public val after: Optional<String?> = Optional.Absent,
) : Query<GetPostCommentQuery.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    GetPostCommentQuery_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> = GetPostCommentQuery_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = com.cyberconnect.link3.type.Query.type
  )
  .selections(selections = GetPostCommentQuerySelections.__root)
  .build()

  @ApolloAdaptableWith(GetPostCommentQuery_ResponseAdapter.Data::class)
  public data class Data(
    public val post: Post?,
  ) : Query.Data

  public data class Post(
    public val comments: Comments,
  )

  public data class Comments(
    public val pageInfo: PageInfo,
    public val list: kotlin.collections.List<List>,
  )

  public data class PageInfo(
    public val startCursor: String,
    public val endCursor: String,
    public val hasNextPage: Boolean,
    public val hasPreviousPage: Boolean,
  )

  public data class List(
    public val id: String,
    public val author: Author,
    public val trendingComments: TrendingComments,
    public val body: String,
    public val likedStatus: LikedStatus1,
    public val likeCount: Int,
    public val commentCount: Int,
    public val publishedAt: Any,
  )

  public data class Author(
    public val lightInfo: LightInfo,
  )

  public data class LightInfo(
    public val handle: String,
    public val avatar: String,
    public val avatarFrameTokenId: String?,
    public val displayName: String,
    public val formattedAddress: String,
  )

  public data class TrendingComments(
    public val list: kotlin.collections.List<List1>,
  )

  public data class List1(
    public val id: String,
    public val body: String,
    public val likedStatus: LikedStatus,
    public val likeCount: Int,
    public val commentCount: Int,
    public val publishedAt: Any,
    public val author: Author1,
  )

  public data class LikedStatus(
    public val liked: Boolean,
  )

  public data class Author1(
    public val lightInfo: LightInfo1,
  )

  public data class LightInfo1(
    public val handle: String,
    public val avatar: String,
    public val displayName: String,
    public val formattedAddress: String,
  )

  public data class LikedStatus1(
    public val liked: Boolean,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "ad07163641de5726527261ddf977f5704aaa396e7b37bf868abebd0aa19d4080"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * query getPostComment($postId: String!, $first: Int = 30 , $after: String) {
     *   post(id: $postId) {
     *     comments(first: $first, after: $after) {
     *       pageInfo {
     *         startCursor
     *         endCursor
     *         hasNextPage
     *         hasPreviousPage
     *       }
     *       list {
     *         id
     *         author {
     *           lightInfo {
     *             handle
     *             avatar
     *             avatarFrameTokenId
     *             displayName
     *             formattedAddress
     *           }
     *         }
     *         trendingComments {
     *           list {
     *             id
     *             body
     *             likedStatus {
     *               liked
     *             }
     *             likeCount
     *             commentCount
     *             publishedAt
     *             author {
     *               lightInfo {
     *                 handle
     *                 avatar
     *                 displayName
     *                 formattedAddress
     *               }
     *             }
     *           }
     *         }
     *         body
     *         likedStatus {
     *           liked
     *         }
     *         likeCount
     *         commentCount
     *         publishedAt
     *       }
     *     }
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "query getPostComment(${'$'}postId: String!, ${'$'}first: Int = 30 , ${'$'}after: String) { post(id: ${'$'}postId) { comments(first: ${'$'}first, after: ${'$'}after) { pageInfo { startCursor endCursor hasNextPage hasPreviousPage } list { id author { lightInfo { handle avatar avatarFrameTokenId displayName formattedAddress } } trendingComments { list { id body likedStatus { liked } likeCount commentCount publishedAt author { lightInfo { handle avatar displayName formattedAddress } } } } body likedStatus { liked } likeCount commentCount publishedAt } } } }"

    public const val OPERATION_NAME: String = "getPostComment"
  }
}