/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_chessoid_liaison_jni_Liaison */

#ifndef _Included_com_chessoid_liaison_jni_Liaison
#define _Included_com_chessoid_liaison_jni_Liaison
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_chessoid_liaison_jni_Liaison
 * Method:    testliaison
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_chessoid_liaison_jni_Liaison_testliaison
  (JNIEnv *, jobject);

/*
 * Class:     com_chessoid_liaison_jni_Liaison
 * Method:    debugMode
 * Signature: (Z)V
 */
JNIEXPORT void JNICALL Java_com_chessoid_liaison_jni_Liaison_debugMode
  (JNIEnv *, jobject, jboolean);

/*
 * Class:     com_chessoid_liaison_jni_Liaison
 * Method:    init_engine
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_com_chessoid_liaison_jni_Liaison_init_1engine
  (JNIEnv *, jobject);

/*
 * Class:     com_chessoid_liaison_jni_Liaison
 * Method:    show_board
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_chessoid_liaison_jni_Liaison_show_1board
  (JNIEnv *, jobject);

/*
 * Class:     com_chessoid_liaison_jni_Liaison
 * Method:    board_as_string
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_chessoid_liaison_jni_Liaison_board_1as_1string
  (JNIEnv *, jobject);

/*
 * Class:     com_chessoid_liaison_jni_Liaison
 * Method:    board
 * Signature: (Lcom/chessoid/model/Board;)Lcom/chessoid/model/Board;
 */
JNIEXPORT jobject JNICALL Java_com_chessoid_liaison_jni_Liaison_board
  (JNIEnv *, jobject, jobject);

/*
 * Class:     com_chessoid_liaison_jni_Liaison
 * Method:    validate_move
 * Signature: (Ljava/lang/String;)Z
 */
JNIEXPORT jboolean JNICALL Java_com_chessoid_liaison_jni_Liaison_validate_1move
  (JNIEnv *, jobject, jstring);

/*
 * Class:     com_chessoid_liaison_jni_Liaison
 * Method:    input_cmd
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_chessoid_liaison_jni_Liaison_input_1cmd
  (JNIEnv *, jobject, jstring);

/*
 * Class:     com_chessoid_liaison_jni_Liaison
 * Method:    doMove
 * Signature: (Ljava/lang/String;)Z
 */
JNIEXPORT jboolean JNICALL Java_com_chessoid_liaison_jni_Liaison_doMove
  (JNIEnv *, jobject, jstring);

/*
 * Class:     com_chessoid_liaison_jni_Liaison
 * Method:    iterate
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_chessoid_liaison_jni_Liaison_iterate
  (JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
#endif
