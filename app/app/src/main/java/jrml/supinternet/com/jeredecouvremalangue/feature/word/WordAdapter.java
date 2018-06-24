package jrml.supinternet.com.jeredecouvremalangue.feature.word;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import jrml.supinternet.com.jeredecouvremalangue.R;

public class WordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private String[] citationDataset;
    private String mCitationTextPlaceholder;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class CitationViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView citationText;
        public CitationViewHolder(View v) {
            super(v);
            citationText = v.findViewById(R.id.citationText);
        }
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MainWordContentViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public MainWordContentViewHolder(View v) {
            super(v);
            //do some other things
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public WordAdapter(String[] myDataset, String citationTextPlaceholder) {
        citationDataset = myDataset;
        mCitationTextPlaceholder = citationTextPlaceholder;
    }

    //invoked to get int viewType
    @Override
    public int getItemViewType(int position){
        return position;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v;
        if (viewType == 0){
            // create a new view
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.word_main_content, parent, false);
            // set the view's size, margins, paddings and layout parameters
            return new MainWordContentViewHolder(v);
        }
        // create a new view
        v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_citation_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
        return new CitationViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        if (holder.getItemViewType() == 0){
            //todo
        }else{
            CitationViewHolder currentViewHolder = (CitationViewHolder) holder;
            currentViewHolder.citationText.setText(String.format(mCitationTextPlaceholder, citationDataset[position - 1]));
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return citationDataset.length + 1;
    }
}
