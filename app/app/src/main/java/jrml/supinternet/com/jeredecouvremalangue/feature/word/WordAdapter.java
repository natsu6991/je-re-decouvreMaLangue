package jrml.supinternet.com.jeredecouvremalangue.feature.word;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;

import jrml.supinternet.com.jeredecouvremalangue.R;

public class WordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Word word;
    private String mCitationTextPlaceholder;
    private boolean isCitationVisible = false;
    private ArrayList<CitationViewHolder> mCitationViewHolders = new ArrayList<>();

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

        public void hideCitations(){
            int resId = R.anim.item_animation_walk_up;
            Animation animation = AnimationUtils.loadAnimation(this.itemView.getContext(), resId);
            this.itemView.setAnimation(animation);

            this.itemView.setVisibility(View.INVISIBLE);
        }

        public void hideCitations(Boolean withAnim){
            if (withAnim){
                int resId = R.anim.item_animation_walk_up;
                Animation animation = AnimationUtils.loadAnimation(this.itemView.getContext(), resId);
                this.itemView.setAnimation(animation);
            }


            this.itemView.setVisibility(View.INVISIBLE);
        }

        public void showCitations(){

            int resId = R.anim.item_animation_fall_down;
            Animation animation = AnimationUtils.loadAnimation(this.itemView.getContext(), resId);
            this.itemView.setAnimation(animation);

            this.itemView.setVisibility(View.VISIBLE);
        }
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MainWordContentViewHolder extends RecyclerView.ViewHolder {
        private TextView nameText;
        private TextView descriptionText;
        private TextView switchCitation;

        // each data item is just a string in this case
        public MainWordContentViewHolder(View v) {
            super(v);
            setAttribute(v);
            //do some other things
        }

        private void setAttribute(View v){
            nameText = v.findViewById(R.id.name);
            descriptionText = v.findViewById(R.id.description);
            switchCitation = v.findViewById(R.id.some_citation_link);
        }

        private void updateView(Word word){
            nameText.setText(word.getName());
            descriptionText.setText(word.getDescription());
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public WordAdapter(Word word, String citationTextPlaceholder) {
        this.word = word;
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
            MainWordContentViewHolder currentViewHolder = (MainWordContentViewHolder) holder;
            currentViewHolder.updateView(word);
            currentViewHolder.switchCitation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    isCitationVisible = !isCitationVisible;
                    if (isCitationVisible){
                        for (CitationViewHolder mCitationViewHolder : mCitationViewHolders){
                            mCitationViewHolder.showCitations();
                        }
                    }else{
                        for (CitationViewHolder mCitationViewHolder : mCitationViewHolders){
                            mCitationViewHolder.hideCitations();
                        }
                    }
                }
            });
        }else{
            CitationViewHolder currentViewHolder = (CitationViewHolder) holder;
            currentViewHolder.citationText.setText(String.format(mCitationTextPlaceholder, word.getCitation().get(position - 1)));
            currentViewHolder.hideCitations(false);
            mCitationViewHolders.add(currentViewHolder);
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return word.getCitation().size() + 1;
    }
}
