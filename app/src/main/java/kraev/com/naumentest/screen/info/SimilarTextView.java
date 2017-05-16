package kraev.com.naumentest.screen.info;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Vladimir Kraev
 */

/*
* Кастомный View автоматически генерирующийся InfoActivity (View слоем приложения)
* на основе ответа сервера
 */

public class SimilarTextView extends android.support.v7.widget.AppCompatTextView {

    int mId;
    String text;


    public SimilarTextView(Context context, int id, String text) {
        super(context);
        mId = id;
        this.setText(text);

        setAppearance(context);
    }

    public SimilarTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SimilarTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void setAppearance(Context context){
        LinearLayout.LayoutParams layoutParams = new LinearLayout
                .LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        this.setTextColor(ContextCompat.getColor(context, android.R.color.holo_blue_light));
        this.setLayoutParams(layoutParams);
    }

    interface onSimilarClickListener extends View.OnClickListener {

    }
}
