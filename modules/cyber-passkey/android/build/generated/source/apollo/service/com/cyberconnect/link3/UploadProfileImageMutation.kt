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
import com.apollographql.apollo3.api.Mutation
import com.apollographql.apollo3.api.Upload
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.adapter.UploadProfileImageMutation_ResponseAdapter
import com.cyberconnect.link3.adapter.UploadProfileImageMutation_VariablesAdapter
import com.cyberconnect.link3.selections.UploadProfileImageMutationSelections
import com.cyberconnect.link3.type.ImageUsage
import com.cyberconnect.link3.type.Upload_Status
import kotlin.Any
import kotlin.String
import kotlin.Unit

public data class UploadProfileImageMutation(
  public val type: ImageUsage,
  public val `file`: Upload,
  public val profileId: String,
) : Mutation<UploadProfileImageMutation.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    UploadProfileImageMutation_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> =
      UploadProfileImageMutation_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = com.cyberconnect.link3.type.Mutation.type
  )
  .selections(selections = UploadProfileImageMutationSelections.__root)
  .build()

  @ApolloAdaptableWith(UploadProfileImageMutation_ResponseAdapter.Data::class)
  public data class Data(
    public val uploadProfileImage: UploadProfileImage,
  ) : Mutation.Data

  public data class UploadProfileImage(
    public val url: Any,
    public val status: Upload_Status,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "840192a91f7c65c3a9d63ef79d18256b5ff82e8b81f6c24ecc3cb622cf64fd64"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * mutation uploadProfileImage($type: ImageUsage!, $file: Upload!, $profileId: ID!) {
     *   uploadProfileImage(imageUsage: $type, profileId: $profileId, file: $file) {
     *     url
     *     status
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "mutation uploadProfileImage(${'$'}type: ImageUsage!, ${'$'}file: Upload!, ${'$'}profileId: ID!) { uploadProfileImage(imageUsage: ${'$'}type, profileId: ${'$'}profileId, file: ${'$'}file) { url status } }"

    public const val OPERATION_NAME: String = "uploadProfileImage"
  }
}