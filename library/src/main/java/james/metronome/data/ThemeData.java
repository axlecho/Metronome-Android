package james.metronome.data;

import android.content.Context;


import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;

import com.afollestad.aesthetic.Aesthetic;

import james.metronome.R;
import james.metronome.utils.ColorUtils;

public class ThemeData {

    private int nameRes;
    private int colorPrimaryRes;
    private int colorAccentRes;
    private int colorBackgroundRes;

    public ThemeData(@StringRes int nameRes, @ColorRes int colorPrimaryRes, @ColorRes int colorAccentRes, @ColorRes int colorBackgroundRes) {
        this.nameRes = nameRes;
        this.colorPrimaryRes = colorPrimaryRes;
        this.colorAccentRes = colorAccentRes;
        this.colorBackgroundRes = colorBackgroundRes;
    }

    public String getName(Context context) {
        return context.getString(nameRes);
    }

    public void apply(Context context) {
        int backgroundColor = ContextCompat.getColor(context, colorBackgroundRes);
        boolean isBackgroundDark = ColorUtils.isColorDark(backgroundColor);

        Aesthetic.get()
                .colorPrimary(ContextCompat.getColor(context, colorPrimaryRes),null)
                .colorAccent(ContextCompat.getColor(context, colorAccentRes),null)
                .colorWindowBackground(backgroundColor,null)
                .textColorPrimary(ContextCompat.getColor(context, isBackgroundDark ? R.color.textColorPrimary : R.color.textColorPrimaryInverse),null)
                .textColorPrimaryInverse(ContextCompat.getColor(context, isBackgroundDark ? R.color.textColorPrimaryInverse : R.color.textColorPrimary),null)
                .textColorSecondary(ContextCompat.getColor(context, isBackgroundDark ? R.color.textColorSecondary : R.color.textColorSecondaryInverse),null)
                .textColorSecondaryInverse(ContextCompat.getColor(context, isBackgroundDark ? R.color.textColorSecondaryInverse : R.color.textColorSecondary),null)
                .colorStatusBarAuto()
                .colorNavigationBarAuto()
                .apply();
    }

}
