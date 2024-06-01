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
import com.apollographql.apollo3.api.Optional
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.adapter.LoginMutation_ResponseAdapter
import com.cyberconnect.link3.adapter.LoginMutation_VariablesAdapter
import com.cyberconnect.link3.selections.LoginMutationSelections
import com.cyberconnect.link3.type.LoginResponse_Status
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit

public data class LoginMutation(
  public val address: Any,
  public val signature: String,
  public val signedMessage: String,
  public val token: Optional<String?> = Optional.Absent,
  public val isEIP1271: Optional<Boolean?> = Optional.Absent,
  public val chainId: Optional<Int?> = Optional.Absent,
) : Mutation<LoginMutation.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    LoginMutation_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> = LoginMutation_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = com.cyberconnect.link3.type.Mutation.type
  )
  .selections(selections = LoginMutationSelections.__root)
  .build()

  @ApolloAdaptableWith(LoginMutation_ResponseAdapter.Data::class)
  public data class Data(
    /**
     * Login to get a user access token.
     */
    public val login: Login,
  ) : Mutation.Data

  public data class Login(
    public val status: LoginResponse_Status,
    public val message: String,
    public val `data`: Data1?,
  )

  public data class Data1(
    public val id: String,
    public val privateInfo: PrivateInfo?,
  )

  public data class PrivateInfo(
    public val address: Any,
    /**
     * User access token, expired in 7 days.
     */
    public val accessToken: String,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "8cbf96f805e32131ccef9d40a8cedea84630b5354ee9c7ea8f0da5e87213d72b"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * mutation login($address: EVMAddress!, $signature: String!, $signedMessage: String!, $token:
     * String, $isEIP1271: Boolean, $chainId: Int) {
     *   login(request: {
     *     address: $address
     *     signature: $signature
     *     signedMessage: $signedMessage
     *     token: $token
     *     isEIP1271: $isEIP1271
     *     chainId: $chainId
     *   }
     *   ) {
     *     status
     *     message
     *     data {
     *       id
     *       privateInfo {
     *         address
     *         accessToken
     *       }
     *     }
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "mutation login(${'$'}address: EVMAddress!, ${'$'}signature: String!, ${'$'}signedMessage: String!, ${'$'}token: String, ${'$'}isEIP1271: Boolean, ${'$'}chainId: Int) { login(request: { address: ${'$'}address signature: ${'$'}signature signedMessage: ${'$'}signedMessage token: ${'$'}token isEIP1271: ${'$'}isEIP1271 chainId: ${'$'}chainId } ) { status message data { id privateInfo { address accessToken } } } }"

    public const val OPERATION_NAME: String = "login"
  }
}