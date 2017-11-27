package com.kholak.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.kholak.swoosh.Utilities.EXTRA_LEAGUE
import com.kholak.swoosh.R
import com.kholak.swoosh.Utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var league = ""
    var selectedSkill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)
        println(league)
    }

    fun unbeginnerBtn(view: View) {
        ballerBtn.isChecked = false
        selectedSkill = "beginner"
    }

    fun unballerBtn(view: View) {
        beginnerBtn.isChecked = false
        selectedSkill = "baller"
    }

    fun finishNextClicked(view: View) {
        if (selectedSkill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_LEAGUE, league)
            finishActivity.putExtra(EXTRA_SKILL, selectedSkill)
            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please select a skill.", Toast.LENGTH_SHORT).show()
        }
    }
}
