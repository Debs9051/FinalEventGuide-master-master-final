package events.tcs.com.events.fragment;


import android.animation.LayoutTransition;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import events.tcs.com.events.R;
import events.tcs.com.events.constant.ApplicationData;
import events.tcs.com.events.data.Card;
import events.tcs.com.events.utils.AppUtils;
import events.tcs.com.events.utils.SharedPreferencesManager;

public class DayTwoFragment extends Fragment {
    private Activity mActivity;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mActivity = getActivity();
        view = inflater.inflate(R.layout.fragment_day_one, container, false);
        LinearLayout parent = (LinearLayout) view.findViewById(R.id.layout_container);
        String user = SharedPreferencesManager.readSharedPref(mActivity, ApplicationData.USER_KEY);
        //set values for Card
        Card obj1 = new Card("Travel to TCS Office", "Travel to TCS Office – Gitanjali Park, complete security procedures", "9:00 AM – 10:00 AM ", " TCS\n",ApplicationData.gpLat,ApplicationData.gpLan, true);
        Card obj2 = new Card();
        switch (user) {
            case "David":
                obj2.setHeading("BI Migration Project");
                obj2.setHeadingDesc("BI Migration Project and BI AMS, JDA and monitoring Workshop with team");
                obj2.setTimming("10:00 AM – 11:00 AM");
                obj2.setOwner(" David and TCS team\n");
                break;
            case "Stephane":
                obj2.setHeading("SAP AMS Workshop");
                obj2.setHeadingDesc("SAP AMS Workshop with team");
                obj2.setTimming("10:00 AM – 11:00AM");
                obj2.setOwner(" Stephane and TCS team\n");
                break;
        }
        Card obj4 = new Card("TCS Capability in BIG DATA and Analytics", "TCS Capability in BIG DATA and Analytics\n" +
                "Case Studies on development projects – preferably Qlikview/Qliksense\n", "11:00 AM – 12:00 PM ", " Sudip Nagbiswas\n", ApplicationData.noLat, ApplicationData.noLan, false);
        Card obj5 = new Card("Tea/Coffee", "Tea/Coffee", "12:00 PM – 12:15 PM", " N/A\n", ApplicationData.noLat, ApplicationData.noLan, false);
        Card obj6 = new Card("Presentation on TCS Assurance Services - Capability", "Presentation on TCS Assurance Services - Capability", "12:15 PM – 01:30 PM", " Janaki Mishra\n", ApplicationData.noLat, ApplicationData.noLan, false);
        Card obj7 = new Card("Lunch @ TCS Office", "Lunch @ TCS Office, personal Time/Mails etc\n", "01:00 PM – 02:00 PM", " N/A\n", ApplicationData.noLat, ApplicationData.noLan, false);
        Card obj13 = new Card("Travel", "Travel to Infospace\n", "02:00 PM – 02:15 PM", " N/A\n", ApplicationData.iLat, ApplicationData.iLan, true);
        Card obj8 = new Card("Floor Walk", "Test Factory – SAP, JDA, POS, BAU Testing for one of the largest Food retailer in UK", "02:15 PM – 02:45 PM", " Arijit Saha\n", ApplicationData.noLat, ApplicationData.noLan, false);
        Card obj11 = new Card("Return to office", "Return to TCS Gitanjali Park", "02:45 PM – 03:00 PM", " N/A\n", ApplicationData.gpLat, ApplicationData.gpLan, true);
        Card obj12 = new Card("Floor walk", "Application Command Center Visit – Large UK based Supermarket Chain", "03:00 PM – 04:00 PM", " TCS\n", ApplicationData.noLat, ApplicationData.noLan, false);
        Card obj9 = new Card("Kolkata City Tour", "Travel to famous places in Kolkata", "04:00 PM – 07:30 PM", " TCS\n", ApplicationData.noLat, ApplicationData.noLan, false);
        Card obj10 = new Card("Dinner", "Invitation for a dinner with TCS ", "07:30 PM – 10:00 PM", " TCS\n", ApplicationData.noLat, ApplicationData.noLan, false);
        createCardView(parent, obj1);
        createCardView(parent, obj2);
        createCardView(parent, obj4);
        createCardView(parent, obj5);
        createCardView(parent, obj6);
        createCardView(parent, obj7);
        createCardView(parent, obj13);
        createCardView(parent, obj8);
        createCardView(parent, obj11);
        createCardView(parent, obj12);
        createCardView(parent, obj9);
        createCardView(parent, obj10);
        return view;
    }

    private void createCardView(LinearLayout parentLinearLayout, final Card cardObject) {
        LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(mActivity.LAYOUT_INFLATER_SERVICE);
        View cardView = inflater.inflate(R.layout.card_layout, null);
        LayoutParams params = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
        );
        params.setMargins(15, 15, 15, 15);
        cardView.setLayoutParams(params);
        LayoutTransition layoutTransition = parentLinearLayout.getLayoutTransition();
        layoutTransition.enableTransitionType(LayoutTransition.CHANGING);
        LinearLayout llHeader = cardView.findViewById(R.id.ll_card_header);
        final LinearLayout llExtension = cardView.findViewById(R.id.ll_card_extentsion);
        final ImageView imageIcon = (ImageView) cardView.findViewById(R.id.iv_card_icon);
        TextView textViewTiming = (TextView) cardView.findViewById(R.id.tv_card_time);
        TextView textViewHeading = (TextView) cardView.findViewById(R.id.tv_card_heading);
        TextView textViewDesc = (TextView) cardView.findViewById(R.id.tv_card_desc);
        TextView textViewOwner = (TextView) cardView.findViewById(R.id.tv_card_owner);
        Button btnNotify = (Button) cardView.findViewById(R.id.btn_remind);
        Button btnNavigate = (Button) cardView.findViewById(R.id.btn_navigate);
        textViewTiming.setText("Timing: " + cardObject.getTimming());
        textViewHeading.setText(cardObject.getHeading());
        textViewDesc.setText(Html.fromHtml(cardObject.getHeadingDesc()));
        textViewOwner.setText("Owner: " + cardObject.getOwner());
        btnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppUtils.scheduleNotification(AppUtils.getNotification(cardObject.getHeading(), cardObject.getHeadingDesc(), mActivity), "2018/06/19 " + cardObject.getTimming().substring(0, cardObject.getTimming().indexOf("–") - 1), mActivity);
            }
        });
        if (cardObject.isTravel()) {
            btnNavigate.setVisibility(View.VISIBLE);
            btnNavigate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri gmmIntentUri = Uri.parse("google.navigation:q=" + cardObject.getLatitude() + "," + cardObject.getLongitude());
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    startActivity(mapIntent);
                }
            });
        } else {
            btnNavigate.setVisibility(View.GONE);
        }

        llHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (llExtension.getVisibility() == View.VISIBLE) {
                    llExtension.setVisibility(View.GONE);
                    imageIcon.setBackgroundResource(R.drawable.ic_arrow_drop_down_black_24dp);
                } else {
                    llExtension.setVisibility(View.VISIBLE);
                    imageIcon.setBackgroundResource(R.drawable.ic_arrow_drop_up_black_24dp);
                }
            }
        });
        parentLinearLayout.addView(cardView, parentLinearLayout.getChildCount());
    }

}
