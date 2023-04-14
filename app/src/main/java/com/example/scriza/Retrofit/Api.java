package com.example.scriza.Retrofit;

import static com.example.scriza.Utility.PreferenceUtility.token;

import com.example.scriza.RepositoryModel.PanVerify.Example;
import com.example.scriza.RepositoryModel.User;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;


import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @Headers({"Accept: application/json"})
    @POST("register")
    Call<User> signUp(@Field("name") String name,
                      @Field("email") String email,
                      @Field("mobile") String mobile,
                      @Field("password") String password,
                      @Field("password_confirmation") String password_confirmation);

    @FormUrlEncoded
    @Headers({"Accept: application/json"})
    @POST("login")
    Call<com.example.scriza.RepositoryModel.Login.Example> login(@Field("email") String email,
                                                                 @Field("password") String password);

    @FormUrlEncoded
    @Headers({"Accept: application/json"})
    @POST("v1/verify/pan")
    Call<Example> panverification(@Field("number") String number,
                                  @Field("provider_id") String provider_id,
                                  @Field("client_id") String client_id,
                                  @Header("Authorization") String api_token);


    @FormUrlEncoded
    @Headers({"Accept: application/json"})
    @POST("v1/verify/aadhaar")
    Call<com.example.scriza.RepositoryModel.AadharWithoutOTP.Example> aadharwitoutOpt(@Field("number") String number,
                                                                                      @Field("provider_id") String provider_id,
                                                                                      @Field("client_id") String client_id,
                                                                                      @Header("Authorization") String api_token);

    @FormUrlEncoded
    @Headers({"Accept: application/json"})
    @POST("v1/verify/upi")
    Call<com.example.scriza.RepositoryModel.UPIVerify.Example> upiverification(@Field("number") String number,
                                                                               @Field("provider_id") String provider_id,
                                                                               @Field("client_id") String client_id,
                                                                               @Header("Authorization") String api_token);


    @FormUrlEncoded
    @Headers({"Accept: application/json"})
    @POST("v1/verify/bank_account")
    Call<com.example.scriza.RepositoryModel.BankAccountVerify.Example> bankAccountVerification(@Field("mobile_number") String mobile_number,
                                                                                               @Field("number") String number,
                                                                                               @Field("ifsc") String ifsc,
                                                                                               @Field("provider_id") String provider_id,
                                                                                               @Field("client_id") String client_id,
                                                                                               @Header("Authorization") String api_token);

    @FormUrlEncoded
    @Headers({"Accept: application/json"})
    @POST("v1/verify/gst")
    Call<com.example.scriza.RepositoryModel.GSTVerify.Example> gstverification(@Field("number") String number,
                                                                               @Field("provider_id") String provider_id,
                                                                               @Field("client_id") String client_id,
                                                                               @Header("Authorization") String api_token);

    @FormUrlEncoded
    @Headers({"Accept: application/json"})
    @POST("v1/verify/chalan")
    Call<com.example.scriza.RepositoryModel.ChalanVerify.Example> chalanverification(@Field("number") String number,
                                                                                     @Field("provider_id") String provider_id,
                                                                                     @Field("client_id") String client_id,
                                                                                     @Header("Authorization") String api_token);


    @FormUrlEncoded
    @Headers({"Accept: application/json"})
    @POST("v1/verify/aadhaar/otp")
    Call<com.example.scriza.RepositoryModel.AadharWithOTP.Example> aadharwithOTP(@Field("number") String number,
                                                                                      @Field("mobile_number") String mobile_number,
                                                                                      @Field("provider_id") String provider_id,
                                                                                      @Field("client_id") String client_id,
                                                                                      @Header("Authorization") String api_token);

    @FormUrlEncoded
    @Headers({"Accept: application/json"})
    @POST("v1/verify/aadhaar/otp/verify")
    Call<com.example.scriza.RepositoryModel.AadharOTPVerification.Example> adharOTPVerify(@Field("otp") String otp,
                                                                                         @Field("client_id") String client_id,
                                                                                         @Field("reference_id") String reference_id,
                                                                                         @Header("Authorization") String api_token);
}
