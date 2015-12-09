package philthesis.animatedlistviewimages;

import android.content.Context;
import android.support.wearable.view.CircledImageView;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 08.12.2015.
 */
public class WearableListAdapter extends WearableListView.Adapter {

    private String[] mDatasetVehicle;
    private String[] mDatasetDistance;
    private ArrayList<Integer> mIcons;
    private final Context mContext;
    private final LayoutInflater mInflater;

    public WearableListAdapter(Context context, String[] datasetVehicle, String[] datasetDistance, ArrayList<Integer> icons) {
        mContext = context;
        mIcons = icons;
        mInflater = LayoutInflater.from(context);
        mDatasetVehicle = datasetVehicle;
        mDatasetDistance = datasetDistance;
    }

    // reference to the type of views you're using
    public static class ItemViewHolder extends WearableListView.ViewHolder {
        private TextView car_tv;
        private TextView distance_tv;
        private CircledImageView provider_img;
        public ItemViewHolder(View itemView) {
            super(itemView);
            // find the text view within the custom item's layout
            car_tv = (TextView) itemView.findViewById(R.id.car_type);
            distance_tv = (TextView) itemView.findViewById(R.id.distance);
            provider_img = (CircledImageView) itemView.findViewById(R.id.circle);
        }
    }

    @Override
    public WearableListView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate custom layout for list items
        return new ItemViewHolder(mInflater.inflate(R.layout.list_item, null));
    }

    @Override
    public void onBindViewHolder(WearableListView.ViewHolder holder, int position) {

        // retrieve the text view
        ItemViewHolder itemHolder = (ItemViewHolder) holder;
        TextView view1 = itemHolder.car_tv;
        TextView view2 = itemHolder.distance_tv;
        CircledImageView view3 = itemHolder.provider_img;


        // replace text contents
        view1.setText(mDatasetVehicle[position]);
        view2.setText(mDatasetDistance[position]);
        view3.setImageResource(mIcons.get(position));

        // replace list item's metadata
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mDatasetDistance.length;
    }
}
