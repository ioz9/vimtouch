/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.momodalo.app.vimtouch;

import android.content.res.Resources;
import android.content.SharedPreferences;
import android.view.KeyEvent;

public class VimSettings {
    private SharedPreferences mPrefs;

    private int mActionBarMode;
    private int mCursorStyle;
    private int mCursorBlink;
    private int mFontSize;
    private int mColorId;
    private boolean mUTF8ByDefault;
    private int mBackKeyAction;
    private int mControlKeyId;
    private int mFnKeyId;
    private int mUseCookedIME;
    private String mShell;
    private String mFailsafeShell;
    private String mInitialCommand;
    private String mTermType;
    private boolean mCloseOnExit;
    private boolean mVerifyPath;
    private boolean mDoPathExtensions;
    private boolean mAllowPathPrepend;
    private boolean mTouchGesture;
    private boolean mSingleTapESC;
    private boolean mZoomBottom;
    private int mQuickbarPos;
    private long mLastVersionCode;

    private String mPrependPath = null;
    private String mAppendPath = null;

    private static final String STATUSBAR_KEY = "statusbar";
    private static final String ACTIONBAR_KEY = "actionbar";
    private static final String CURSORSTYLE_KEY = "cursorstyle";
    private static final String CURSORBLINK_KEY = "cursorblink";
    private static final String FONTSIZE_KEY = "fontsize";
    private static final String COLOR_KEY = "color";
    private static final String UTF8_KEY = "utf8_by_default";
    private static final String BACKACTION_KEY = "backaction";
    private static final String CONTROLKEY_KEY = "controlkey";
    private static final String FNKEY_KEY = "fnkey";
    private static final String IME_KEY = "ime";
    private static final String SHELL_KEY = "shell";
    private static final String INITIALCOMMAND_KEY = "initialcommand";
    private static final String TERMTYPE_KEY = "termtype";
    private static final String CLOSEONEXIT_KEY = "close_window_on_process_exit";
    private static final String VERIFYPATH_KEY = "verify_path";
    private static final String PATHEXTENSIONS_KEY = "do_path_extensions";
    private static final String PATHPREPEND_KEY = "allow_prepend_path";
    private static final String TOUCHGESTURE_KEY = "touch_gesture";
    private static final String SINGLETAPESC_KEY = "single_tap_esc";
    private static final String ZOOMBOTTOM_KEY = "zoombottom";
    private static final String QUICKBARPOS_KEY = "quickbar_pos";
    public static final String LASTVERSION_KEY = "last_version";

    public static final int WHITE = 0xffffffff;
    public static final int BLACK = 0xff000000;
    public static final int BLUE =  0xff344ebd;
    public static final int GREEN = 0xff00ff00;
    public static final int AMBER = 0xffffb651;
    public static final int RED =   0xffff0113;
    public static final int HOLO_BLUE = 0xff33b5e5;

    // foreground index, foreground color, background index, background color
    public static final int[][] COLOR_SCHEMES = {
        {0, BLACK, 7, WHITE},
        {7, WHITE, 0, BLACK},
        {7, WHITE, 4, BLUE},
        {2, GREEN, 0, BLACK},
        {3, AMBER, 0, BLACK},
        {1, RED, 0, BLACK},
        {4, HOLO_BLUE, 0, BLACK}
    };

    public static final int ACTION_BAR_MODE_NONE = 0;
    public static final int ACTION_BAR_MODE_ALWAYS_VISIBLE = 1;
    public static final int ACTION_BAR_MODE_HIDES = 2;
    private static final int ACTION_BAR_MODE_MAX = 2;

    /** An integer not in the range of real key codes. */
    public static final int KEYCODE_NONE = -1;

    public static final int CONTROL_KEY_ID_NONE = 7;
    public static final int[] CONTROL_KEY_SCHEMES = {
        KeyEvent.KEYCODE_DPAD_CENTER,
        KeyEvent.KEYCODE_AT,
        KeyEvent.KEYCODE_ALT_LEFT,
        KeyEvent.KEYCODE_ALT_RIGHT,
        KeyEvent.KEYCODE_VOLUME_UP,
        KeyEvent.KEYCODE_VOLUME_DOWN,
        KeyEvent.KEYCODE_CAMERA,
        KEYCODE_NONE
    };

    public static final int FN_KEY_ID_NONE = 7;
    public static final int[] FN_KEY_SCHEMES = {
        KeyEvent.KEYCODE_DPAD_CENTER,
        KeyEvent.KEYCODE_AT,
        KeyEvent.KEYCODE_ALT_LEFT,
        KeyEvent.KEYCODE_ALT_RIGHT,
        KeyEvent.KEYCODE_VOLUME_UP,
        KeyEvent.KEYCODE_VOLUME_DOWN,
        KeyEvent.KEYCODE_CAMERA,
        KEYCODE_NONE
    };

    public static final int BACK_KEY_STOPS_SERVICE = 0;
    public static final int BACK_KEY_CLOSES_WINDOW = 1;
    public static final int BACK_KEY_CLOSES_ACTIVITY = 2;
    public static final int BACK_KEY_SENDS_ESC = 3;
    public static final int BACK_KEY_SENDS_TAB = 4;
    private static final int BACK_KEY_MAX = 4;

    public VimSettings(Resources res, SharedPreferences prefs) {
        readDefaultPrefs(res);
        readPrefs(prefs);
    }

    private void readDefaultPrefs(Resources res) {
        mActionBarMode = res.getInteger(R.integer.pref_actionbar_default);
        mCursorStyle = Integer.parseInt(res.getString(R.string.pref_cursorstyle_default));
        mCursorBlink = Integer.parseInt(res.getString(R.string.pref_cursorblink_default));
        mFontSize = Integer.parseInt(res.getString(R.string.pref_fontsize_default));
        mColorId = Integer.parseInt(res.getString(R.string.pref_color_default));
        mUTF8ByDefault = res.getBoolean(R.bool.pref_utf8_by_default_default);
        mBackKeyAction = Integer.parseInt(res.getString(R.string.pref_backaction_default));
        mControlKeyId = Integer.parseInt(res.getString(R.string.pref_controlkey_default));
        mFnKeyId = Integer.parseInt(res.getString(R.string.pref_fnkey_default));
        mUseCookedIME = Integer.parseInt(res.getString(R.string.pref_ime_default));
        mFailsafeShell = res.getString(R.string.pref_shell_default);
        mShell = mFailsafeShell;
        mInitialCommand = res.getString(R.string.pref_initialcommand_default);
        mTermType = res.getString(R.string.pref_termtype_default);
        mCloseOnExit = res.getBoolean(R.bool.pref_close_window_on_process_exit_default);
        mVerifyPath = res.getBoolean(R.bool.pref_verify_path_default);
        mDoPathExtensions = res.getBoolean(R.bool.pref_do_path_extensions_default);
        mAllowPathPrepend = res.getBoolean(R.bool.pref_allow_prepend_path_default);
        mTouchGesture = res.getBoolean(R.bool.pref_touch_gesture_default);
        mSingleTapESC = res.getBoolean(R.bool.pref_single_tap_esc_default);
        mZoomBottom = res.getBoolean(R.bool.pref_zoombottom_default);
        mQuickbarPos = res.getInteger(R.integer.pref_quickbar_pos_default);
        mLastVersionCode = 0;
    }

    public void readPrefs(SharedPreferences prefs) {
        mPrefs = prefs;
        mActionBarMode = readIntPref(ACTIONBAR_KEY, mActionBarMode, ACTION_BAR_MODE_MAX);
        // mCursorStyle = readIntPref(CURSORSTYLE_KEY, mCursorStyle, 2);
        // mCursorBlink = readIntPref(CURSORBLINK_KEY, mCursorBlink, 1);
        mFontSize = readIntPref(FONTSIZE_KEY, mFontSize, 20);
        mColorId = readIntPref(COLOR_KEY, mColorId, COLOR_SCHEMES.length - 1);
        mUTF8ByDefault = readBooleanPref(UTF8_KEY, mUTF8ByDefault);
        mBackKeyAction = readIntPref(BACKACTION_KEY, mBackKeyAction, BACK_KEY_MAX);
        mControlKeyId = readIntPref(CONTROLKEY_KEY, mControlKeyId,
                CONTROL_KEY_SCHEMES.length - 1);
        mFnKeyId = readIntPref(FNKEY_KEY, mFnKeyId,
                FN_KEY_SCHEMES.length - 1);
        mUseCookedIME = readIntPref(IME_KEY, mUseCookedIME, 1);
        mShell = readStringPref(SHELL_KEY, mShell);
        mInitialCommand = readStringPref(INITIALCOMMAND_KEY, mInitialCommand);
        mTermType = readStringPref(TERMTYPE_KEY, mTermType);
        mCloseOnExit = readBooleanPref(CLOSEONEXIT_KEY, mCloseOnExit);
        mVerifyPath = readBooleanPref(VERIFYPATH_KEY, mVerifyPath);
        mDoPathExtensions = readBooleanPref(PATHEXTENSIONS_KEY, mDoPathExtensions);
        mAllowPathPrepend = readBooleanPref(PATHPREPEND_KEY, mAllowPathPrepend);
        mTouchGesture = readBooleanPref(TOUCHGESTURE_KEY, mTouchGesture);
        mSingleTapESC = readBooleanPref(SINGLETAPESC_KEY, mSingleTapESC);
        mZoomBottom = readBooleanPref(ZOOMBOTTOM_KEY, mZoomBottom);
        mQuickbarPos = readIntPref(QUICKBARPOS_KEY, mQuickbarPos,4);
        mLastVersionCode = mPrefs.getLong(LASTVERSION_KEY, 0);
        mPrefs = null;  // we leak a Context if we hold on to this
    }

    private int readIntPref(String key, int defaultValue, int maxValue) {
        int val;
        try {
            val = Integer.parseInt(
                mPrefs.getString(key, Integer.toString(defaultValue)));
        } catch (NumberFormatException e) {
            val = defaultValue;
        }
        val = Math.max(0, Math.min(val, maxValue));
        return val;
    }

    private String readStringPref(String key, String defaultValue) {
        return mPrefs.getString(key, defaultValue);
    }

    private boolean readBooleanPref(String key, boolean defaultValue) {
        return mPrefs.getBoolean(key, defaultValue);
    }

    public long getLastVersionCode(){
        return mLastVersionCode;
    }

    public int actionBarMode() {
        return mActionBarMode;
    }

    public int getCursorStyle() {
        return mCursorStyle;
    }

    public int getCursorBlink() {
        return mCursorBlink;
    }

    public void setFontSize(int s) {
        mFontSize = s;
    }

    public int getFontSize() {
        return mFontSize;
    }

    public int[] getColorScheme() {
        return COLOR_SCHEMES[mColorId];
    }

    public boolean defaultToUTF8Mode() {
        return mUTF8ByDefault;
    }

    public int getBackKeyAction() {
        return mBackKeyAction;
    }

    public boolean backKeySendsCharacter() {
        return mBackKeyAction >= BACK_KEY_SENDS_ESC;
    }

    public int getBackKeyCharacter() {
        switch (mBackKeyAction) {
            case BACK_KEY_SENDS_ESC: return 27;
            case BACK_KEY_SENDS_TAB: return 9;
            default: return 0;
        }
    }

    public int getControlKeyId() {
        return mControlKeyId;
    }

    public int getFnKeyId() {
        return mFnKeyId;
    }

    public int getControlKeyCode() {
        return CONTROL_KEY_SCHEMES[mControlKeyId];
    }

    public int getFnKeyCode() {
        return FN_KEY_SCHEMES[mFnKeyId];
    }

    public boolean useCookedIME() {
        return (mUseCookedIME != 0);
    }

    public String getShell() {
        return mShell;
    }

    public String getFailsafeShell() {
        return mFailsafeShell;
    }

    public String getInitialCommand() {
        return mInitialCommand;
    }

    public String getTermType() {
        return mTermType;
    }

    public boolean closeWindowOnProcessExit() {
        return mCloseOnExit;
    }

    public boolean verifyPath() {
        return mVerifyPath;
    }

    public boolean doPathExtensions() {
        return mDoPathExtensions;
    }

    public boolean allowPathPrepend() {
        return mAllowPathPrepend;
    }

    public void setPrependPath(String prependPath) {
        mPrependPath = prependPath;
    }

    public String getPrependPath() {
        return mPrependPath;
    }

    public void setAppendPath(String appendPath) {
        mAppendPath = appendPath;
    }

    public String getAppendPath() {
        return mAppendPath;
    }

    public boolean getTouchGesture() {
        return mTouchGesture;
    }

    public boolean getSingleTapESC() {
        return mSingleTapESC;
    }

    public boolean getZoomBottom() {
        return mZoomBottom;
    }
    
    public int getQuickbarPosition() {
        return mQuickbarPos;
    }
}
