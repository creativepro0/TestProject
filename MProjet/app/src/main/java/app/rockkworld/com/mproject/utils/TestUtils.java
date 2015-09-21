package app.rockkworld.com.mproject.utils;

import app.rockkworld.R;

/**
 * Created by divya on 16/9/15.
 */
public class TestUtils {

    public static int getUserDpResourse(String dp) {
        try {
            int dpInt=Integer.parseInt(dp);

            switch (dpInt){
                case 1:
                    return R.drawable.profile1;
                case 2:
                    return R.drawable.profile2;
                case 3:
                    return R.drawable.profile3;
                case 4:
                    return R.drawable.profile4;
                case 5:
                    return R.drawable.profile5;
                case 39:
                    return R.drawable.userdp;
            }
        }catch (NumberFormatException e){}


        return R.drawable.profile1;
    }

    public static int getImageResourse(String imgStr) {

        try {
            int imgInt=Integer.parseInt(imgStr);

            switch (imgInt){
                case 1:
                    return R.drawable.img1;
                case 2:
                    return R.drawable.img2;
                case 3:
                    return R.drawable.img3;
                case 4:
                    return R.drawable.img8;
                case 5:
                    return R.drawable.img5;
                case 6:
                    return R.drawable.img6;
                case 7:
                    return R.drawable.img7;
                case 8:
                    return R.drawable.img8;
                case 9:
                    return R.drawable.img9;
                case 10:
                    return R.drawable.img10;
                case 11:
                    return R.drawable.img11;
                case 12:
                    return R.drawable.img12;
                case 13:
                    return R.drawable.img13;
            }
        }catch (NumberFormatException e){}

        return R.drawable.img1;
    }

}
