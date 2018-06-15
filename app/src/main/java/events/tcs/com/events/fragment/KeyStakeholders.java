package events.tcs.com.events.fragment;


import android.animation.LayoutTransition;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import events.tcs.com.events.R;
import events.tcs.com.events.data.CarRecyclerViewItem;
import events.tcs.com.events.data.Card;

public class KeyStakeholders extends Fragment {
    private Activity mActivity;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //set values for Card
        CarRecyclerViewItem obj1 = new CarRecyclerViewItem("Sunandan Das\nRetail & CPG Head, Kolkata", R.drawable.sunandan_das);
        CarRecyclerViewItem obj2 = new CarRecyclerViewItem("Kaushik Bhattacharya\nDelivery Head, LVMH",R.drawable.photo);
        CarRecyclerViewItem obj3 = new CarRecyclerViewItem("Siddhartha Bhattacharya\nSephora SAP Delivery Lead",R.drawable.sddhartha_photo);
        CarRecyclerViewItem obj4 = new CarRecyclerViewItem("Deepika Ghsh\nJDA & BI Delivery Lead",R.drawable.photo_deepika);
        CarRecyclerViewItem obj5 = new CarRecyclerViewItem("Sudip Nagbiswas\nBI Practice Head, Kolkata",R.drawable.profile2);
        CarRecyclerViewItem obj6 = new CarRecyclerViewItem("Shimpy Saluja\nSAP HCM COE",R.drawable.shimpy);
        CarRecyclerViewItem obj7 = new CarRecyclerViewItem("Sanjay Das\nSAP Delivery Head, Kolkata",R.drawable.sanjay_das);
        CarRecyclerViewItem obj8 = new CarRecyclerViewItem("Janaki Mishra\nRetail QE Head, Kolkata",R.drawable.janaki);

        /*Card obj2 = new Card("Welcome address and agenda discussion", "Welcome address, visit expectations and agenda discussion\n" +"• Introduction with TCS Senior Management at Kolkata\n"+"• Meet with TCS Offshore Team Leads\n" + "Expectations from the Visit\n", "11:00 PM – 11:45 PM ", " TCS and Sephora\n", 0.0, 0.0, false);
        Card obj3 = new Card("Tea/Coffee", "Tea/Coffee", "11:45 AM – 12:00 PM", " TCS\n", ApplicationData.noLat, ApplicationData.noLan, false);
        Card obj4 = new Card("Sephora Account Review", "Sephora Account Review \n" + "• Relationship Journey\n" + "• Meet offshore Team – LVMH Floor Visit\n", "12:00 PM – 01:30 PM", " Kaushik\n", ApplicationData.noLat, ApplicationData.noLan, false);
        Card obj5 = new Card("Lunch", "Lunch @ TCS Office,  \n" +
                "Personal Time/Mails etc", "01:30 PM – 03:00 PM", " N/A\n", ApplicationData.noLat, ApplicationData.noLan, false);
        Card obj6 = new Card("Floor-Walk", "End to End Service Delivery Experience for a Large (multi-country) Home Improvement Retailer – (Kingfisher) – SAP Transformation and AMS full services play\n", "03:00 PM – 04:00 PM", " Aniruddha Bhattacharjee\n", ApplicationData.noLat, ApplicationData.noLan, false);
        Card obj7 = new Card("Tea/Coffee", "Tea/Coffee@ TCS Office", "04:00 PM – 04:15 PM", " N/A\n", ApplicationData.noLat, ApplicationData.noLan, false);
        Card obj8 = new Card("BI Migration Project", "BI Migration Project Workshop with team", "04:15 PM – 05:45 PM", " David and TCS team\n", ApplicationData.noLat, ApplicationData.noLan, false);
        Card obj9 = new Card("SAP Project", "SAP AMS Workshop with team", "04:15 PM – 05:45 PM", " Stephane and TCS team\n", ApplicationData.noLat, ApplicationData.noLan, false);
        Card obj10 = new Card("Wrap", "Wrap-up for the day", "05:45 PM – 06:00 PM", " N/A\n", ApplicationData.noLat, ApplicationData.noLan, false);
        Card obj11 = new Card("Travel to Hotel", "Informal dinner – specialized local food", "06:00 PM – 06:30 PM", " TCS\n", ApplicationData.hotelLat, ApplicationData.hotelLat, true);*/
        mActivity = getActivity();
        view = inflater.inflate(R.layout.fragment_stakeholders, container, false);
        LinearLayout parent = (LinearLayout) view.findViewById(R.id.layout_container);
        createCardView(parent, obj1);
        createCardView(parent, obj2);

        createCardView(parent, obj3);
        createCardView(parent, obj4);
       createCardView(parent, obj5);
        createCardView(parent, obj6);
        createCardView(parent, obj7);
        createCardView(parent, obj8);
        /*createCardView(parent, obj9);
        createCardView(parent, obj10);
        createCardView(parent, obj11);*/
        return view;
    }

    private void createCardView(LinearLayout parentLinearLayout, final CarRecyclerViewItem cardObject) {
        LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(mActivity.LAYOUT_INFLATER_SERVICE);
        View cardView = inflater.inflate(R.layout.activity_card_view_item, null);
        LayoutParams params = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
        );
        params.setMargins(25, 25,25, 25);

        cardView.setLayoutParams(params);
        LayoutTransition layoutTransition = parentLinearLayout.getLayoutTransition();
        layoutTransition.enableTransitionType(LayoutTransition.CHANGING);
        //LinearLayout llHeader = cardView.findViewById(R.id.ll_card_header);
        //final LinearLayout llExtension = cardView.findViewById(R.id.ll_card_extentsion);
        final ImageView imageIcon = (ImageView) cardView.findViewById(R.id.card_view_image);
        TextView textViewTiming = (TextView) cardView.findViewById(R.id.card_view_image_title);
        /*TextView textViewHeading = (TextView) cardView.findViewById(R.id.tv_card_heading);
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
                AppUtils.scheduleNotification(AppUtils.getNotification(cardObject.getHeading(), cardObject.getHeadingDesc(), mActivity), "2018/06/18 " + cardObject.getTimming().substring(0, cardObject.getTimming().indexOf("–") - 1), mActivity);
            }
        })
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
        });*/
        imageIcon.setImageResource(cardObject.getCarImageId());
        //imageIcon.setBackgroundResource(R.drawable.);
        textViewTiming.setText(cardObject.getCarName());
        parentLinearLayout.addView(cardView, parentLinearLayout.getChildCount());
    }
}
